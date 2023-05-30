<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>

<h2>All Employees:</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>

    <c:forEach var="emp" items= "${allEmps}">
        <tr>
            <td>${emp.name}</td>
            <th>${emp.surname}</th>
            <th>${emp.department}</th>
            <th>${emp.salary}</th>
        </tr>
    </c:forEach>
</table>
<br>

<input type="button" value="Add"
    onclick="window.location.href = 'addNewEmployee' "/>
</body>

</html>
