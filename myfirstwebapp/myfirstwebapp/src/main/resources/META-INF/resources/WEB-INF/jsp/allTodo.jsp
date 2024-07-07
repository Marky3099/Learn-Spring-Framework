<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>ToDo List</h1>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description }</td>
					<td>${todo.targetDate }</td>
					<td>${todo.done }</td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-primary">Edit</a> <a
						href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add ToDo</a>
</div>
<%@ include file="common/footer.jspf"%>