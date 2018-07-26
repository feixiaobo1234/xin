<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="typegoods">
		<input type="hidden" name="option" value="3" />
		<!-- 4是更新	商品 -->
		<input type="hidden" name="id" value="${typegoods.id }">
		<table>
			<tr>
				<td>种类名称:
				<td>
				<td><input type="text" name="name" value="${typegoods.name }"></td>
			</tr>

			<tr>
				<td>种类描述:
				<td>
				<td><input type="text" name="gdesc" value="${typegoods.gdesc }"></td>
				
			</tr>
			
			<tr>
				<td>种类等级:
				<td>
				<td><input type="text" name="grade" value="${typegoods.grade }"></td>
			</tr>
			<tr>
			<tr>
				<td>种类图片:
				<td>
				<td><input type="text" name="image" value="${typegoods.image }"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="修改种类"></td>
			</tr>
		</table>
	</form>
</body>
</html>