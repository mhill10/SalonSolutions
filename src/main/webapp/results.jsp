<%@include file="tagLib.jsp"%>
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready(function() {
        $('#userTable').DataTable();
    } );
</script>



<html><body>

<div class="container-fluid">

    <h2>Users: </h2>
    <table id="userTable"  class="display" cellspacing="0" width=""100%>
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
        <th>Profile Pic: </th>
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
                <td>${user.userProfilePic}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

</body>
</html>