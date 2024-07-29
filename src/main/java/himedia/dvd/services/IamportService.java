package himedia.dvd.services;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class IamportService {
    private static final String API_URL = "https://api.iamport.kr";
    private static final String API_KEY = "1218882588657631"; // 하드코딩된 API 키
    private static final String API_SECRET = "6CSYeEyCSebGAlCb7MixiARc9d7cPuUVJaLI9bs13N7WOhmq47PwYPg0ZV0v5ieKREPj52gfUAsltjfH"; // 하드코딩된 API 시크릿

    public String getToken() throws Exception {
        String tokenUrl = API_URL + "/users/getToken";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(tokenUrl);

            JsonObject json = new JsonObject();
            json.addProperty("imp_key", API_KEY);
            json.addProperty("imp_secret", API_SECRET);

            httpPost.setEntity(new StringEntity(json.toString()));
            httpPost.setHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseString = EntityUtils.toString(response.getEntity());
                JsonObject responseJson = JsonParser.parseString(responseString).getAsJsonObject();
                return responseJson.get("response").getAsJsonObject().get("access_token").getAsString();
            }
        }
    }

    public boolean requestPayment(String token, String merchantUid, double amount) throws Exception {
        String paymentUrl = API_URL + "/payments/prepare";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(paymentUrl);

            JsonObject json = new JsonObject();
            json.addProperty("merchant_uid", merchantUid); // 고유한 주문번호
            json.addProperty("amount", amount); // 결제 금액

            httpPost.setEntity(new StringEntity(json.toString()));
            httpPost.setHeader("Authorization", "Bearer " + token);
            httpPost.setHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String responseString = EntityUtils.toString(response.getEntity());
                JsonObject responseJson = JsonParser.parseString(responseString).getAsJsonObject();
                return responseJson.get("code").getAsInt() == 0;
            }
        }
    }
}
