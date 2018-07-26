<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="typegoods" method="get" >
	<input type="hidden" name="option" value="1"> 
	<table >
	<tr>
	
	<td>种类名称<input type="text" name="name"></td>
	<td>种类图片<input type="text" name="image"></td>
	<td>种类级别<input type="text" name="grade"></td>
	<td>种类描述<input type="text" name="desc"></td>
	 
	<td><input type="submit" value="添加种类"></td>
	</tr>
	</table>
	</form>


</body>
</html>