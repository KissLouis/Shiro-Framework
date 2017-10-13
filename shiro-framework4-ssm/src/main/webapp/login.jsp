<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/login" method="post">
		username:<input type="text" name="name" /><br> password:<input
			type="password" name="pwd" /><br> <input type="submit"
			value="登陆">
	</form>
</body>
</html>