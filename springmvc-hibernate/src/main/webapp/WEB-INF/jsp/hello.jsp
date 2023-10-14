<html>
<body>
<h2>Hello World! ABC</h2>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="hello/save">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>


<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Email</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td><a href="hello/editemp/${emp.id}">Edit</a></td>
            <td><a href="hello/deleteemp/${emp.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
