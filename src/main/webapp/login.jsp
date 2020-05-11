<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/head.jsp"%>
<%@include file="templates/nav.jsp"%>
<%@include file="templates/header.jsp"%>
<section class="body">
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</section>

<%@include file="templates/footer.jsp"%>