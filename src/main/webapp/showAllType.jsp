<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
td {
	text-align: center;
}
</style>
<body>
	<h1>显示所有的种类</h1>
	<form>
		<table>
			<tr>
				<th>种类序列</th>
				<th>种类名称</th>
				<th>种类描述</th>
				<th>种类图片</th>
				<th>种类等级</th>
				<th>种类操作</th>
			</tr>

			<c:forEach items="${list}" var="typegood">

				<tr>
					<td>${typegood.id}</td>
					<td>${typegood.name }</td>
					<td>${typegood.desc }</td>
					<td>${typegood.image }</td>
					<td>${typegood.grade }</td>
					<td><a href="typegoods?option=5&id=${typegood.id}">修改 </a> 
						<a href="typegoods?option=2&id=${typegood.id}">删除
					</a></td>
				</tr>

			</c:forEach>

			<tr>
				<td></td>
			</tr>
			<tr>
				<td></td>
			</tr>

		</table>
	</form>




</body>
</html>