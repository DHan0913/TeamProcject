<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Home</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/footer.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px;
            background-color: #f8f9fa;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            margin-top: 30px;
            flex: 1;
        }
        .button {
            margin-bottom: 20px;
        }
        .list-container {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div id="container">
        <!-- 헤더 포함 -->
        <%@ include file="/WEB-INF/views/includes/header.jsp" %>
        
        <c:if test="${authUser != null && authUser.role == 1}">
            <div class="text-center mb-4">
                <button class="btn btn-primary" onclick="location.href='<c:url value="/admin/home" />'">관리자 화면</button>
            </div>
        </c:if>
        
        <div id="search-bar" class="container">
            <form id="searchForm" action="${pageContext.request.contextPath}/products/search" method="GET" class="form-inline">
                <input type="text" name="keyword" class="form-control mr-sm-2" placeholder="검색">
                <button type="button" class="btn btn-outline-success" onclick="goSearch('')">검색</button>
                <input type="hidden" name="filter" value="">
                <input type="hidden" id="genre" name="genre">
                <input type="hidden" id="authorized" name="authorized" value="true">
            </form>
        </div>
        
        <div id="content" class="container">
            <div class="button btn-group" role="group" aria-label="Basic example">
                <button type="button" class="btn btn-secondary" onclick="goSearch('공포')">공포</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('드라마')">드라마</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('스릴러')">스릴러</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('코미디')">코미디</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('로맨스')">로맨스</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('액션')">액션</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('SF')">SF</button>
                <button type="button" class="btn btn-secondary" onclick="goSearch('')">필터해제</button>
            </div>
            
            <div class="list-container table-responsive">
                <table class="table table-bordered">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">영화제목</th>
                            <th scope="col">장르</th>
                            <th scope="col">출시일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${products}">
                            <tr>
                                <th scope="row">${product.productNo}</th>
                                <td><a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">${product.productName}</a></td>
                                <td>${product.genre}</td>
                                <td>${product.releaseDate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <footer class="footer">
        <div class="container">
            <div class="footer-links">
                <a href="#">사이트 소개</a>
                <a href="#">team project</a>
            </div>
            <div class="footer-copy">
                &copy; 2024 Admin Panel. All rights reserved.
            </div>
        </div>
    </footer>
    
    <script type="text/javascript">
        function goSearch(type){
            var filter = type === '' ? 'productName' : 'genre';
            var form = document.getElementById("searchForm");
            
            form.genre.value = type;
            form.filter.value = filter;
            form.submit();
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.amazonaws.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
