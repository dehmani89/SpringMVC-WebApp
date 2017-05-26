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
<h2>Welcome ${nameParam}</h2>
</div>

<!-- FOOTER FRAGMENT --> 
<%@include file="../common/footer.jspf" %>