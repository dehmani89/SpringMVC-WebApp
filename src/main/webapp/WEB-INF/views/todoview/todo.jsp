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
	<fieldset class="form-group">
		<form:label path="targetDate">Target Date</form:label>
		<form:input path="targetDate" type="text" class="form-control" required="required"/>
		<form:errors path="targetDate" cssClass="text-warning"></form:errors>
	</fieldset>
	<input class="btn btn-success" type="submit" value="Submit">
	
	
</form:form>
</div>


<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>