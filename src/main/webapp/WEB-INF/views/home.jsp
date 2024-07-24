<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<link href="<c:url value='/css/usershome.css' />" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
<!-- 사용자 정의 CSS -->
</head>
<body>
	<c:import url="/WEB-INF/views/includes/header.jsp" />
	<div id="container">
		<!-- 헤더 포함 -->

		<div class="header-buttons">
			<form id="searchForm" action="${pageContext.request.contextPath}/products/search" method="GET" class="search-form">
				<input type="hidden" name="filter" value="productName">
				<input type="hidden" id="genre" name="genre">
				<input type="hidden" id="authorized" name="authorized" value="true">
			</form>
		</div>

		<div id="search-bar" class="container">
			<div class="button-group">
				<input type="text" name="keyword" class="search-input" placeholder="검색">
					<button type="submit" class="btn custom-btn">검색</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('공포')">공포</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('드라마')">드라마</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('스릴러')">스릴러</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('코미디')">코미디</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('로맨스')">로맨스</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('액션')">액션</button>
				<button type="button" class="btn custom-btn" onclick="goSearch('SF')">SF</button>
				<button type="button" class="btn custom-btn" onclick="window.location.href='${pageContext.request.contextPath}/'">필터해제</button>
			    <c:if test="${authUser != null && authUser.role == 1}">
			    <button class="btn custom-btn admin-btn"
					onclick="location.href='${pageContext.request.contextPath}/admin/home'">관리자 화면</button>
					</c:if>
			</div>
		</div>

		<div id="content" class="container">
			<div class="list-container">
				<c:forEach var="product" items="${products}">
					<div class="item">
						<h2>${product.productName}</h2>
						<c:if test="${not empty product.img}">
							<a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">
								<img src="<c:url value='/upload-images/${product.img}' />"
								alt="${product.productName}" />
							</a>
						</c:if>
					</div>
				</c:forEach>
				<!-- 페이징 네비게이션 추가 -->
				<div class="pagination">
					<c:if test="${currentPage > 1}">
						<a href="${pageContext.request.contextPath}/main?page=${currentPage - 1}" class="page-link">Previous</a>
					</c:if>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a href="${pageContext.request.contextPath}/main?page=${i}" class="page-link ${i == currentPage ? 'active' : ''}">${i}</a>
					</c:forEach>
					<c:if test="${currentPage < totalPages}">
						<a href="${pageContext.request.contextPath}/main?page=${currentPage + 1}" class="page-link">Next</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- 푸터 포함 -->
	<c:import url="/WEB-INF/views/admin/includes/footer.jsp" />

	<script type="text/javascript">
		function goSearch(type) {
			var filter = type === '' ? 'productName' : 'genre';
			var form = document.getElementById("searchForm");
			form.genre.value = type;
			form.filter.value = filter;
			form.submit();
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
</body>
</html>
