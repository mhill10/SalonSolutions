<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script><%@include file="../templates/dataTable.js"%></script>
<%@include file="../templates/head.jsp"%>
<%@include file="../templates/nav.jsp"%>
<%@include file="../templates/header.jsp"%>

<section class="body">
    <h2 class="contentHeading">Edit User:</h2>
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
        </thead>
        <tbody>

        <c:forEach var="selectedUser" items="${requestScope.selectedUser}">
            <tr>
                <td>${selectedUser.id}</td>
                <td>${selectedUser.userEmailAddress}</td>x
                <td>${selectedUser.userDisplayName}</td>
                <td>${selectedUser.userFirstName}</td>
                <td>${selectedUser.userLastName}</td>
                <td>${selectedUser.userStreetAddress}</td>
                <td>${selectedUser.userCity}</td>
                <td>${selectedUser.userState}</td>
                <td>${selectedUser.userZipCode}</td>
                <td>${selectedUser.userPhone}</td>

            </tr>
        </c:forEach>
        </tbody>

    </table>

</section>