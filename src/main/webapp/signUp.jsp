<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/templates/head.jsp"%>
<%@include file="/templates/nav.jsp"%>
<%@include file="/templates/header.jsp"%>
<section class="body">
    <h1 class="contentHeading">Register an Account:</h1>
    <form action="${pageContext.request.contextPath}/signUpUser" class="form-inline">
        <div class="form-group">
            <label for "userFirstName">First Name:</label><br />
            <input type="text" name="userFirstName"/>
        </div>

        <input type="submit" name="submit" value="search" class="btn btn-primary">Search</input>
        <input type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</input>
    </form>
</section>