package himedia.dvd.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.AccessControlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {
	
    @Autowired
    private AccessControlService accessControlService;
    
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	     // 클라이언트 IP 주소 가져오기
        String ipAddress = getClientIp(request);

        // IP가 차단되었는지 확인
        if (accessControlService.isBlocked(ipAddress)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");
            return false;
        }

		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}

		return true;
	}
	
	  // 부적절한 접근 아이피 리턴
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
