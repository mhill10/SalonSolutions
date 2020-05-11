<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../templates/head.jsp"%>
<%@include file="../templates/nav.jsp"%>
<%@include file="../templates/header.jsp"%>
<section class="body">
<form action="${pageContext.request.contextPath}/searchUsers" class="form-inline">
    <div class="form-group">
        <span id="enterName">Enter Last Name to Search in Box Below:</span><br />
        <input type="text" name="userSearchTerm"/>
    </div>

    <input type="submit" name="submit" value="search" class="btn btn-primary">Search</input>
    <input type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</input>
</form>
</section>
<%@include file="../templates/footer.jsp"%>