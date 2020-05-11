<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script><%@include file="../templates/dataTable.js"%></script>
<%@include file="../templates/head.jsp"%>
<%@include file="../templates/nav.jsp"%>
<%@include file="../templates/header.jsp"%>


<section class="body">
<h2 class="contentHeading">Salon Solutions Users: </h2>

    <table id="userTable">
        <thead>
        <th>User Id: </th>
        <th>Email Address: </th>
        <th>Display Name</th>
        <th>First Name: </th>
        <th>Last Name: </th>
        <th>Street Address: </th>
        <th>City: </th>
        <th>State: </th>
        <th>Zip Code: </th>
        <th>Phone Number: </th>
        <th>Edit User: </th>
<%--        <th>Profile Pic: </th>--%>
        </thead>
        <tbody>

        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.userEmailAddress}</td>x
                <td>${user.userDisplayName}</td>
                <td>${user.userFirstName}</td>
                <td>${user.userLastName}</td>
                <td>${user.userStreetAddress}</td>
                <td>${user.userCity}</td>
                <td>${user.userState}</td>
                <td>${user.userZipCode}</td>
                <td>${user.userPhone}</td>
                <td><form action="${pageContext.request.contextPath}/editUser">
                    <input type="hidden" name="userId" value="${user.id}">
                <input type="submit" name="submit" value="editUser" class="btn btn-primary"/></form>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</section>

<%@include file="../templates/footer.jsp"%>