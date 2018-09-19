<%@ include file="/WEB-INF/views/include.jsp"%>
<section class="content-header">
	<h1>Attendance</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Attendance</li>
	</ol>
</section>

<c:if test="${pagetype == 1}">
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Search</h3>
						</div>
						<form:form action="addattendance.htm" method="post" modelAttribute="studentDetailVO">
							<div class="box-body">
								<div class="row">
									<div class="col-xs-4">
										<div class="form-group">
											<label>Department</label>
											<form:select class="form-control" path="departmentId">
												<c:forEach items="${departments}" var="dep">
													<option value="${dep.id}">${dep.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Course</label> 
											<form:select class="form-control" path="courseId">
												<c:forEach items="${courses}" var="cr">
													<option value="${cr.id}">${cr.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Period</label> 
											<form:select class="form-control" path="coursePeriod">
												<c:forEach items="${periods}" var="pd">
													<option value="${pd.id}">${pd.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Section</label> 
											<form:select class="form-control" path="courseSection">
												<c:forEach items="${sections}" var="sc">
													<option value="${sc.id}">${sc.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="box-footer">
								<a href="#" class="btn btn-default">Cancel</a>
								<button type="submit" class="btn btn-success">Search</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</c:if>

<c:if test="${pagetype == 2}">
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Search</h3>
						</div>
						<form:form action="addattendance.htm" method="post" modelAttribute="studentDetailVO">
							<div class="box-body">
								<div class="row">
									<div class="col-xs-4">
										<div class="form-group">
											<label>Department</label>
											<form:select class="form-control" path="departmentId">
												<c:forEach items="${departments}" var="dep">
													<option value="${dep.id}">${dep.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Course</label> 
											<form:select class="form-control" path="courseId">
												<c:forEach items="${courses}" var="cr">
													<option value="${cr.id}">${cr.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Period</label> 
											<form:select class="form-control" path="coursePeriod">
												<c:forEach items="${periods}" var="pd">
													<option value="${pd.id}">${pd.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-xs-4">
										<div class="form-group">
											<label>Section</label> 
											<form:select class="form-control" path="courseSection">
												<c:forEach items="${sections}" var="sc">
													<option value="${sc.id}">${sc.name}</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
							<div class="box-footer">
								<a href="#" class="btn btn-default">Cancel</a>
								<button type="submit" class="btn btn-success">Search</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<form:form action="saveattendance.htm" method="post" modelAttribute="absentDetailVOs">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Students</h3>
						</div>
						<div class="box-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width: 10px">#</th>
										<th>User Name</th>
										<th>User Type</th>
										<th style="width: 70px">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${absentDetailVOs}" var="abUser" varStatus="loop">
										<tr>
											<td>${loop.index + 1}</td>
											<td>${abUser.userVO.firstName}</td>
											<td>${abUser.userVO.role}</td>
											<td>
												<form:checkbox path="absentDetailVOs[${loop.index}].absent" />
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="box-footer">
							<a href="#" class="btn btn-default">Cancel</a>
							<button type="submit" class="btn btn-success">Update</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</section>
</c:if>
