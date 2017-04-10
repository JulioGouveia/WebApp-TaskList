<%@include file="/WEB-INF/views/header.jsp"%>


<h2>Task List</h2>
<p>All your tasks in one place.</p>

<form:form action="${s:mvcUrl('TLC#createNewTask').build() }" method="post" >
	<fieldset class="newTaskForm">

		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="taskName"></label>
			<div class="col-md-4">
				<input id="taskName" name="taskName" type="text"
					placeholder="New Task" class="form-control input-md">
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="saveNewTask"></label>
			<div class="col-md-4">
				<button type="submit" name="saveNewTask"
					class="newTaskBtn btn btn-primary">new</button>
			</div>
		</div>

	</fieldset>
</form:form>
<div class="container">
	<table>
		<c:forEach items="${allTasks}" var="task">
			<tr>
				<td>${task.date.getTime() }</td>
			</tr>
			<tr>
				<td>${task.taskName }</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>