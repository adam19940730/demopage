<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户界面</title>
</head>
<body>
	<h3>添加用户</h3>
	<form action="User_save" method="post">
		name:<input type="text" name="name" /> <br />
		birthday:<input type="text" name="brithday" /> <br />
		money:<input type="text" name="money" /> <br />
		<button type="submit">save</button>
	</form>
</body>
</html>