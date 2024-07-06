<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>상품 상세</h1>
    <table border="1">
        <tr>
            <td>
               <img src="<c:url value='/upload-images/${vo.imageName}' />" />
            </td>
        </tr>
        <tr>
        <td>
            <table border="1" style="height:300px; width:400px;"> 
            <tr align="center">
                <td>이름</td>
                <td>${vo.productname}</td>
            </tr>
			<tr align="center">
                <td>장르</td>
                <td>${vo.genre}</td>
            </tr>
			<tr align="center">
                <td>출시일</td>
                <td>${vo.release_date}</td>
            </tr>
            <tr align="center">
                <td>소개</td>
                <td>${vo.content}</td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <select name="count">
                        <c:forEach begin="1" end="7" var="i">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select> &nbsp;일
                    <input type="submit" value="대여">
                </td>
            </tr>
            </table>
        </td>
        </tr>
    </table>
</body>
</html>
