<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 수정 페이지</title>
    <!-- CSS 링크 추가 -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/modify.css'/>">
    <!-- JavaScript 파일 링크 (옵션) -->
    <script src="<c:url value='/javascript/modify.js' />" type="text/javascript"></script>
</head>
<body>
    <div class="container">
        <h1>상품 수정</h1>
        
        <!-- 상품 수정 폼 -->
        <form method="post" action="<c:url value='/admin/modify'/>" onsubmit="return confirmSubmit();">
            <input type="hidden" name="productNo" value="${productVo.productNo }"/>
            
            <table>
                <tr>
                    <td>상품명:</td>
                    <td><input type="text" name="productName" value="${productVo.productName }" required></td>
                    <td>장르:</td>
                    <td><input type="text" name="genre" value="${productVo.genre }" required></td>
                </tr>
                <tr>
                    <td>출시일:</td>
                    <td><input type="date" name="releaseDate" value="${productVo.releaseDate}" required></td>
                    <td>내용:</td>
                    <td><textarea id="content" name="content" required>${productVo.content }</textarea></td>
                </tr>
                <tr>
                    <td>상태:</td>
                    <td><input type="text" name="status" value="${productVo.status }" required></td>
                    <td>이미지:</td>
                    <td><input type="text" name="img" value="${productVo.img }" required></td>
                </tr>
                <tr>
                    <td>비디오 이름:</td>
                    <td colspan="3"><input type="text" name="video" value="${productVo.video}" required></td>
                </tr>
                <tr>
                    <td colspan="4">
                        <a href="<c:url value='/admin/productlist' />" class="cancel-link">취소</a>
                        <input type="submit" value="수정">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
