package himedia.dvd.repositories.vo;

public class ProductVo {
    private Long productNo;
    private String productName;
    private String genre;
    private String releaseDate;
    private String content;
    private String status;
    private String img;

    public ProductVo() {
    }

    public ProductVo(String productName, String genre, String releaseDate, String content, String status, String img) {
        this.productName = productName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.content = content;
        this.status = status;
        this.img = img;
    }

    public Long getProductNo() {
        return productNo;
    }

    public void setProductNo(Long productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "productNo=" + productNo +
                ", productName='" + productName + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
