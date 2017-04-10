<%@include file="/WEB-INF/views/header.jsp"%>

<div >
	<form:form action="${s:mvcUrl('LC#createUser').build() }" method="post" class="form-horizontal">
		<fieldset class="createAcc">

			<!-- Form Name -->
			<legend> Create Account</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">Name:</label>
				<div class="col-md-4">
					<input id="name" name="name" type="text" placeholder="full name"
						class="form-control input-md">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">E-mail:</label>
				<div class="col-md-4">
					<input id="email" name="email" type="email"
						placeholder="e-mail adress" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">Password:</label>
				<div class="col-md-4">
					<input id="password" name="password" type="password"
						placeholder="password" class="form-control input-md">
				</div>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</fieldset>
	</form:form>

</div>
</body>
</html>