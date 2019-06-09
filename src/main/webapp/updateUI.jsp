<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户界面</title>
</head>
<body>
	<h3>修改用户</h3>
	<form action="User_update" method="post">
		<input type="text" name="id" value="${user.id }" /><br />
		name:<input type="text" name="name" /> <br />
		birthday:<input type="text" name="brithday" /> <br />
		money:<input type="text" name="money" /> <br />
		<button type="submit">update</button>
	</form>
</body>
</html>