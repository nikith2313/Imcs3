<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form id="myform" action="createPassenger" method="POST" modelAttribute="Passenger">
<table>
    <tr>
        <td>First Name :</td>
        <td><form:input path="firstName" /></td>
    </tr>
    <tr>
        <td>lastName :</td>
        <td><form:input path="lastName" /></td>
    </tr>
    
    <tr>
        <td>email :</td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td>address :</td>
        <td><form:input path="address" /></td>
    </tr>
    
     <tr>
        <td>telephone Number :</td>
        <td><form:input path="telePhoneno" /></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" value="login"></td>
    </tr>
</table>
</form:form>
</body>
</html>