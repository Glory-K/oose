<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 조회</title>
</head>
<body>
<div id="body_container">
    <div>
        <p>회원 조회</p>
    </div>
    <div>
        <form action="/front/member/list" method="POST">
            <p>이름</p>
            <input type="text" name="name">
            <input type="submit" value="검색" name="action">
        </form>
    </div>
    <div>
        <br>
        <table width="700" border="3" bordercolor="lightgray">
            <thead>
            <tr>
                <td>아이디</td>
                <td>비밀번호</td>
                <td>이 름</td>
                <td>주 소</td>
                <td>전화번호</td>
                <td>개인정보동의일</td>
                <td>정기권여부</td>
            </tr>
            </thead>
            <c:forEach var="ordinarymember" items="${members}">
                <tr>
                    <td>${ordinarymember.id}</td>
                    <td>${ordinarymember.pw}</td>
                    <td>${ordinarymember.name}</td>
                    <td>${ordinarymember.address}</td>
                    <td>${ordinarymember.phoneNum}</td>
                    <td>${ordinarymember.info_agree_date}</td>
                    <td>${ordinarymember.regular}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div>
        <br>
        <form action="/front/member/list" method="POST">
            <input type="submit" value="뒤로가기" name="action">
        </form>
    </div>
</div>
</body>
</html>