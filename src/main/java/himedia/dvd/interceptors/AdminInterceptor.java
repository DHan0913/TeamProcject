package himedia.dvd.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import himedia.dvd.repositories.vo.UserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserVo authAdmin = (UserVo) session.getAttribute("authAdmin");

		if (authAdmin == null || authAdmin.getRole() != 1) {
			response.sendRedirect(request.getContextPath() + "/users/login");
			return false;
		}

		return true;
	}
}
