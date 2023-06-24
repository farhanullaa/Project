<%@ include file= "common/header.jspf" %>
<%@ include file= "common/navigation.jspf" %>
	<div class="container">
		<hr>
		<h1>Your Todos</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target date</th>
					<th>Is it done?</th>
				</tr>
			</thead>
			<tbody>
				<C:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">Delete</a></td>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">Update</a></td>
					</tr>
				</C:forEach>
			</tbody>
		</table>
		<a href="add-todos" class="btm btn-success">Add Todo</a>
	</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>