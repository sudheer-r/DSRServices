<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<style type="text/css">
.error {
	color: red;
}

table {
	border-collapse: collapse;
}

td {
	font-weight: bold;
}
</style>
</head>
<body>
	<h1 align="center">Register User</h1>
	<spring:form action="${pageContext.request.contextPath}/registerUser"
		modelAttribute="user">
		<table>
			<tr>
				<td><spring:label path="name">Name </spring:label></td>
				<td><spring:input path="name" /></td>
				<td><spring:errors path="name" cssClass="error"></spring:errors></td>
			</tr>
			<tr>
				<td><spring:label path="age">Age </spring:label></td>
				<td><spring:input path="age" /></td>
				<td><spring:errors path="age" cssClass="error"></spring:errors></td>
			</tr>
			<tr>
				<td><spring:label path="city">City </spring:label></td>
				<td><spring:input path="city" /></td>
				<td><spring:errors path="city" cssClass="error"></spring:errors></td>
			</tr>
			<tr>
				<td><spring:label path="profession">Profession </spring:label></td>
				<td><spring:input path="profession" /></td>
				<td><spring:errors path="profession" cssClass="error"></spring:errors></td>
			</tr>
			<tr>
				<td><spring:label path="company">Company </spring:label></td>
				<td><spring:input path="company" /></td>
				<td><spring:errors path="company" cssClass="error"></spring:errors></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><spring:button value="submit"
						name="submit" >Submit</spring:button></td>
			</tr>
		</table>
	</spring:form>

</body>
</html>