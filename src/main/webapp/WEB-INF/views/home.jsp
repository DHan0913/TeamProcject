<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
<link href="<c:url value='/css/usershome.css' />" rel="stylesheet">
<link href="<c:url value='/css/footer.css' />" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
</head>
<body>
    <c:import url="/WEB-INF/views/includes/header.jsp" />
    <!-- 사이드바 토글 버튼 -->
    <div id="sidebar-toggle" class="btn custom-btn" onclick="toggleSidebar()">
        <i class="fas fa-bars"></i> 메뉴
    </div>
    <div id="container">
        <!-- 사이드바 -->
        <div id="sidebar" class="hidden">
            <div class="search-form">
                <form id="searchForm" action="${pageContext.request.contextPath}/products/search" method="GET">
                    <input type="hidden" name="filter" value="productName">
                    <input type="hidden" id="genre" name="genre">
                    <input type="hidden" id="authorized" name="authorized" value="true">
                    <input type="text" name="keyword" class="search-input" placeholder="검색">
                    <button type="submit" class="btn custom-btn">검색</button>
                </form>
            </div>
            <div class="category-buttons">
                <button type="button" class="btn custom-btn" onclick="goSearch('공포')">공포</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('드라마')">드라마</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('스릴러')">스릴러</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('코미디')">코미디</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('로맨스')">로맨스</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('액션')">액션</button>
                <button type="button" class="btn custom-btn" onclick="goSearch('SF')">SF</button>
                <button type="button" class="btn custom-btn" onclick="window.location.href='${pageContext.request.contextPath}/'">필터해제</button>
                <c:if test="${authUser != null && authUser.role == 1}">
                    <button class="btn custom-btn admin-btn" onclick="location.href='${pageContext.request.contextPath}/admin/home'">관리자 화면</button>
                </c:if>
            </div>
        </div>
        <!-- 메인 콘텐츠 -->
        <div id="content" class="container">
            <div class="list-container">
                <c:forEach var="product" items="${products}">
                    <div class="img-container">
                        <c:if test="${not empty product.img}">
                            <a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">
                                <img src="<c:url value='/upload-images/${product.img}' />" alt="${product.productName}" />
                            </a>
                        </c:if>
                        <h2>${product.productName}</h2>
                    </div>
                </c:forEach>
            </div>
       <!-- 페이징 네비게이션 추가 -->
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <a href="${pageContext.request.contextPath}/main?page=${currentPage - 1}" class="page-link">이전</a>
                </c:if>
                <c:if test="${currentPage < totalPages}">
                    <a href="${pageContext.request.contextPath}/main?page=${currentPage + 1}" class="page-link">다음</a>
                </c:if>
            </div>
        </div>
    </div>
    <!-- 푸터 포함 -->
    <c:import url="/WEB-INF/views/admin/includes/footer.jsp" />
    <script type="text/javascript">
        function toggleSidebar() {
            var sidebar = document.getElementById("sidebar");
            sidebar.classList.toggle("open");
            sidebar.classList.toggle("hidden");

            // 사이드바가 열릴 때 메인 콘텐츠의 왼쪽 여백 조정
            var content = document.getElementById("content");
            var sidebarToggle = document.getElementById("sidebar-toggle");
            if (sidebar.classList.contains("open")) {
                content.style.marginLeft = "250px";
                sidebarToggle.style.opacity = 0; // 사이드바 열릴 때 버튼 숨김
            } else {
                content.style.marginLeft = "0";
                sidebarToggle.style.opacity = 1; // 사이드바 닫힐 때 버튼 표시
            }
        }

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
