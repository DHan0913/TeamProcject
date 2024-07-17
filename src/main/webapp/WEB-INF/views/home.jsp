<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOD</title>
</head>
<body>
   <div id="container">
      <!-- 헤더 포함 -->
      <c:import url="/WEB-INF/views/includes/header.jsp" />
       <c:if test="${authUser != null && authUser.role == 1}">
               <tr>
                  <td colspan="4">
                     <button onclick="location.href='<c:url value="/admin/home" />'">관리자 화면</button>
                  </td>
               </tr>
            </c:if>
      <div id="search-bar">
         <form id="searchForm" action="${pageContext.request.contextPath}/products/search" method="GET">
            <input type="text" name="keyword" placeholder="검색">
            <button type="button" onclick="goSearch('')">검색</button>
            <input type="hidden" name="filter" value="">
            <input type="hidden" id="genre" name="genre">
         </form>
      </div>
   </div>

   <div id="content">
      <div class="button" style="float:left;">
         <button onclick="goSearch('공포')">공포</button>
         <button onclick="goSearch('드라마')">드라마</button>
         <button onclick="goSearch('스릴러')">스릴러</button>
         <button onclick="goSearch('코미디')">코미디</button>
         <button onclick="goSearch('로맨스')">로맨스</button>
         <button onclick="goSearch('액션')">액션</button>
         <button onclick="goSearch('SF')">SF</button>
         <button onclick="goSearch('')">필터해제</button>
      </div>
      <div class="list-container">
         <table border="1" width="100%">
            <tr>
               <th>번호</th>
               <th>영화제목</th>
               <th>장르</th>
               <th>출시일</th>
            </tr>
            <c:forEach var="product" items="${products}">
               <tr>
                  <td>${product.productNo}</td>
                  <td><a href="${pageContext.request.contextPath}/products/detail?productNo=${product.productNo}">${product.productName}</a></td>
                  <td>${product.genre}</td>
                  <td>${product.releaseDate}</td>
               </tr>
            </c:forEach>
           
         </table>
      </div>
   </div>
</body>
<script type="text/javascript">
   function goSearch(type){
      var filter = type === '' ? 'productName' : 'genre';
      var form = document.getElementById("searchForm");
      
      form.genre.value = type;
      form.filter.value = filter;
      form.submit();
   }
</script>
</html>
