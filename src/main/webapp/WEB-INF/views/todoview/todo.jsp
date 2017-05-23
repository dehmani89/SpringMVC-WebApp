<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Todos Page!!</title>
<!-- LOAD CSS FILES HERE -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<p>Hello ${nameParam}</p>


<div class="container">
<h2>Add a Todo</h2>
<!-- 
	using the form: spring style coding that allows us to bind data with the controller
	for example commandName="todo" on the view side gets binded with the model in the TodoController
 -->
<form:form method="post" commandName="todo">
	<fieldset class="form-group">
		<form:hidden path="id"/>
		<form:label path="desc">Description</form:label>
		<form:input path="desc" type="text" class="form-control" required="required"/>
		<form:errors path="desc" cssClass="text-warning"></form:errors>
	</fieldset>
	<input class="btn btn-success" type="submit" value="Submit">
	
	
</form:form>
</div>

<!-- LOAD JS FILES HERE -->		
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    
</body>
</html>