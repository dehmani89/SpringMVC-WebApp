<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Todos Page!!</title>
<!-- LOAD CSS FILES HERE -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h2>Hello ${nameParam}</h2>

<div class="container">
<table class="table table-striped">
	<caption>Your Todos Are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Completed</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td>
						<a class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete!</a>
						<a class="btn btn-warning" href="/update-todo?id=${todo.id}">Update!</a></td>
				</tr>
			</c:forEach>	
		</tbody>
</table>

<div>
	<a class="btn btn-success" href="/add-todo">Submit!</a>
</div>

</div>

<!-- LOAD JS FILES HERE -->		
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    
</body>
</html>