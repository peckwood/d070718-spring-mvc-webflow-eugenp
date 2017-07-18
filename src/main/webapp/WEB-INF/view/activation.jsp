<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World</h2>
<a href="${flowEXecutionUrl}">Start</a>
<hr />
<!-- <input type="submit" name="_eventId_success" value="Proceed" />
<input type="submit" name="_eventId_failure" value="Cancel" /> -->
<hr />
<form method="post" action="${flowExecutionUrl}">
	<input type="hidden" name="_eventId" value="activate">
	<input type="submit" value="Proceed" />
</form>
<form method="post" action="${flowExecutionUrl}">
	<input type="hidden" name="_eventId" value="cancel">
	<input type="submit" value="Cancel">
</form>
</body>
</html>