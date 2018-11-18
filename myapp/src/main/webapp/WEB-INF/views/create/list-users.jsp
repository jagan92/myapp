<%@ include file="/WEB-INF/views/include.jsp"%>
<c:if test="${not empty message && not empty msgtype}">
	<div class="alert alert-${msgtype} alert-dismissible">
	   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
	   <h4><i class="icon fa fa-check"></i> Alert!</h4>
	   <c:out value="${message}" />
	 </div>
</c:if>
<section class="content-header">
	<h1>All User</h1>
	<ol class="breadcrumb">
		<li><a href="dashboard.htm"><i class="fa fa-dashboard"></i>
				Home</a></li>
		<li class="active">All User</li>
	</ol>
</section>

<section class="content">
	<!-- Info boxes -->
	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">All Users</h3>
					<a href="addUser.htm" class="pull-right btn btn-info btn-sm">Add User</a>
				</div>
				<!-- /.box-header -->
				<div class="box-body no-padding">
					<table class="table table-striped">
						<thead>
							<tr>
								<th style="width: 10px">#</th>
								<th>Name</th>
								<th>User Name</th>
								<th>User Type</th>
								<th style="width: 40px">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userVOs}" var="user" varStatus="loop">
								<tr>
									<td>${loop.index + 1}</td>
									<td>${user.firstName} ${user.lastName}</td>
									<td>${user.loginId}</td>
									<td>${user.role}</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
</section>
<script>
	alert("${sessionRole}");
</script>