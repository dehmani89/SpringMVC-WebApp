<!-- 
	Using JSP Fragments to separate the items that are needed for every page such as header/footer/navigation etc.
	This way the code will be organized in separate fragements and we use the include tag to add the needed
	Fragments as needed in different pages.
 -->
<!-- HEADER FRAGMENT --> 
<%@include file="../common/header.jspf" %>
<!-- Navigation Bar FRAGMENT --> 
<%@include file="../common/navigation.jspf" %>


<!-- MAIN CONTENT OF THE PAGE GOES HERE --> 
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
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"></fmt:formatDate></td>
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

<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>