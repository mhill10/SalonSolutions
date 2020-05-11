<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/templates/head.jsp"%>
<%@include file="/templates/nav.jsp"%>
<%@include file="/templates/header.jsp"%>
<section class="body">
    <h1 class="contentHeading">Register an Account:</h1>
    <form action="${pageContext.request.contextPath}/signUpUser" class="signUpForm">
        <div class="form-group">
            <label for="userFirstName">First Name:</label><br />
            <input type="text" id="userFirstName" name="userFirstName"/>
        </div>
        <div class="form-group">
            <label for="userLastName">Last Name:</label><br />
            <input type="text" id="userLastName" name="userLastName"/>
        </div>
        <div class="form-group">
            <label for="userEmailAddress">Email Address:</label><br />
            <input type="text" id="userEmailAddress" name="userEmailAddress"/>
        </div>
        <div class="form-group">
            <label for="passwordOriginal">Password:</label><br />
            <input type="text" id="passwordOriginal" name="passwordOriginal"/>
        </div>
        <div class="form-group">
            <label for="passwordConfirmation">Confirm Password:</label><br />
            <input type="text" id="passwordConfirmation" name="passwordConfirmation"/>
        </div>
        <input type="submit" name="submit" value="Request Account" class="btn btn-primary"/>
    </form>
</section>