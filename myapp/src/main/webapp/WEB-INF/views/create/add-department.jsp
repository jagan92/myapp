<%@ include file="/WEB-INF/views/include.jsp"%>
<section class="content-header">
	<h1>Add Department</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Add Department</li>
	</ol>
</section>

<section class="content">
	<!-- Info boxes -->
	<div class="row">
		<div class="col-md-12">
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">User Details</h3>
				</div>
				<form:form action="saveDepartment.htm" method="post"
					modelAttribute="masterDetailVO">
					<div class="box-body">
					<form:input type="hidden" path="masterType" />
						<div class="row">
							<div class="col-xs-4">
								<div class="form-group">
									<label>Department Name</label>
									<form:input type="text" class="form-control" path="name"
										placeholder="Department name" />
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<a href="dashboard.htm" class="btn btn-default">Cancel</a>
						<button type="submit" class="btn btn-success">Save</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>
