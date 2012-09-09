<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello spring</title>
</head>
<body>
	<h2>NTIS JTMS Client</h2>
	
	<form:form action="/NtisJtmsClient/publish/ntis/send" method="POST">

		<div style="margin-bottom:20px">
			<label for="urlToSend">URL for data publish</label>
			<input id="urlToSend" type="input" name="url" />
		</div>

		<div>
			<input type="submit" name="configuration" value="Send configuration data"/>
			<input type="submit" name="equipment" value="Send ANPR equipment definitions"/>
		</div>
	</form:form>

</body>
</html>