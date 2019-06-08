<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户数据展示界面</title>
<style type="text/css">
	a {
		text-decoration: none;
		cursor: pointer;
	}
</style>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		var flag = false;
		$("#pg").on("input",function(){
			var pgObj = $("#pg").val();
			var zz = /^(\d){1,2}$/;
			if(zz.test(pgObj)){
				flag = true;
			}else{
				flag = false;
				alert("您的输入有误，请重新输入！");
			}
		});
		$("#inForm").submit(function(){
			return flag;
		});
	</script>
</head>
<body>
	<a href="index.jsp">继续注册</a>
	<table class="table">
		<tr>
			<td>id</td>
			<td>name</td>
			<td>brithday</td>
			<td>money</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${page.list }" var="u">
		
			<tr>
				<td>${u.id }</td>
				<td>${u.name }</td>
				<td>${u.brithday }</td>
				<td>${u.money }</td>
				<td>
					<a href="User_delete?id=${u.id }">删除</a>
					|
					<a href="User_updateUI?id=${u.id }"></a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				
				<c:if test="${page.pg != 1 }">
					<a href="User_find?pg=1">首页</a>
				</c:if>
				
				<a href="User_find?pg=${page.pre }">上一页</a>
				
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${page.pg == x }">
						<font color="red">
							${x }
						</font>
					</c:if>
					<c:if test="${page.pg != x }">
						<a href="User_find?pg=${x }">
							${x }
						</a>
					</c:if>
				</c:forEach>
				
				<a href="User_find?pg=${page.next }">下一页</a>
				
				<c:if test="${page.pg != page.maxPage }">
					<a href="User_find?pg=${page.maxPage }">末页</a>
				</c:if>
				
				<font color="red" size="4">
					${page.pg }
				</font>
				/
				${page.maxPage }
				
				<form action="User_find" style="display: inline" name="inForm" id="inForm">
					跳到第<input size="1" type="text" name="pg" id="pg" />页
					<button type="submit">GO</button>
				</form>
			</td>
		</tr>
		
	</table>
</body>
</html>