<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<h3>Apply Form</h3>
	<form:form action="submitForm" modelAttribute="student">
		Name: <form:input path="name"/>
		<input type="submit" value="Submit"/> 
	</form:form>
</body>
</html>