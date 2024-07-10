<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Product</title>
</head>
<body>
    <form method="post" action="<c:url value='/admin/modify'/>">
        <input type="hidden" name="productNo" value="${productVo.productNo }"/>
        <table border="1" width="100%">
            <tr>
                <td>상품이름</td>
                <td><input type="text" name="productName" value="${productVo.productName }"></td>
                <td>장르</td>
                <td><input type="text" name="genre" value="${productVo.genre }"></td>
                <td>내용</td>
                <td><textarea id="content" name="content">${productVo.content }</textarea></td>
            </tr>
            <tr>
                <td colspan="6">
                    <a href="<c:url value='/admin/productlist' />">취소</a>
                    <input type="submit" value="수정">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
