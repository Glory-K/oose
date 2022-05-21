<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계약대장 등록</title>
    <style>
    </style>
</head>
<body>
<center>
    <h1>회원가입</h1>
    <form action="/front/member/regist" method="POST">
        <table border="1" width="600" height="150" bgcolor="#778899">
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id"/><input type="button" value="중복확인"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw"/></td>
            </tr>
            <tr>
                <td>이 름</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>주 소</td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="phoneNum"/></td>
            </tr>
            <tr>
                <td>개인정보동의일</td>
                <td><input type="text" name="info_agree_date"/></td>
            </tr>
            <tr>
                <td>정기권</td>
                <td>
                    <input type="radio" name="regular" value="0">보유X
                    <input type="radio" name="regular" value="1">보유
                </td>
            </tr>
        </table>
        <br/> <input id="regist" type="submit" value="등록" name="action"><input type="reset" value="초기화"><input id="cancel" type="submit" value="돌아가기" name="action">
    </form>
</center>
</body>
</html>