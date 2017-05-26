<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Log In</title>

<link href="<c:url value="/customResources/login.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/customResources/login.js" />"></script>

</head>
<body>

    <div class="container">
	<div class="login-container">
            <div id="output"></div>
            <div class="avatar"></div>
            <div class="form-box">
                <form action="/login" method="POST">
                    <input name="name" type="text" placeholder="username">
                    <input name="password" type="password" placeholder="password">
                    <button class="btn btn-info btn-block login" type="submit">Login</button>
                </form>
             <p><font color="red">${errorMessage}</font></p>    
            </div>
        </div>
        
</div>



<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>