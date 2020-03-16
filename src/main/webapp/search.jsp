<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>Search Users</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/searchUsers" class="form-inline">
    <div class="form-group">
        <span id="enterName">Enter Last Name to Search in Box Below:</span><br />
        <input type="text" name="userSearchTerm"/>
    </div>

    <input type="submit" name="submit" value="search" class="btn btn-primary">Search</input>
    <input type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</input>
</form>
</body>
</html>
