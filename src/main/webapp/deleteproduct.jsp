<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="product"method="post">

<input type="hidden" name="option" value="3"/>
<table>
    <tr><h1>删除数据</h1></tr>
	<tr>
		<td>请输入id<td><input type="text" name="id" /></td>
	</tr>
	<tr>
	    <td><input type="submit" value="删除"></td>
	</tr>
</table>
</form>
</body>
</html>