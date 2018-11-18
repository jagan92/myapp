<%@ include file="/WEB-INF/views/include.jsp"%>
<section class="content-header">
	<h1>Add User</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Add User</li>
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
				<form:form action="saveUser.htm" method="post"
					modelAttribute="userVO">
					<div class="box-body">
						<div class="row">
							<div class="col-xs-4">
								<div class="form-group">
									<label>User Type</label> 
									<form:select class="form-control" id="select_role" onchange="changeRoleSelect()" path="role" required="">
										<option value="">Select Type</option>
										<option value="student">Student</option>
										<option value="staff">Staff</option>
									</form:select>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label>First Name</label>
									<form:input type="text" class="form-control" path="firstName"
										placeholder="First name" />
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label>Last Name</label>
									<form:input type="text" class="form-control" path="lastName"
										placeholder="Last name" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4 clsHideStudent">
								<div class="form-group">
									<label>Department</label>
									<form:select class="form-control" path="studentDetailVO.departmentId">
										<c:forEach items="${departments}" var="dep">
											<option value="${dep.id}">${dep.name}</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-xs-4 clsHideStudent">
								<div class="form-group">
									<label>Course</label> 
									<form:select class="form-control" path="studentDetailVO.courseId">
										<c:forEach items="${courses}" var="cr">
											<option value="${cr.id}">${cr.name}</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-xs-4 clsHideStudent">
								<div class="form-group">
									<label>Period</label> 
									<form:select class="form-control" path="studentDetailVO.coursePeriod">
										<c:forEach items="${periods}" var="pd">
											<option value="${pd.id}">${pd.name}</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-xs-4 clsHideStudent">
								<div class="form-group">
									<label>Section</label> 
									<form:select class="form-control" path="studentDetailVO.courseSection">
										<c:forEach items="${sections}" var="sc">
											<option value="${sc.id}">${sc.name}</option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-4 clsHideStaff hide">
								<div class="form-group">
									<label>Staff Role</label> 
									<form:select class="form-control" path="staffDetailVO.staffRole" required="">
										<option value="">Select Role</option>
										<option value="hod">HOD</option>
										<option value="professor">Professor</option>
										<option value="assistant_professor">Assistant Professor</option>
										<option value="lecturer">Lecturer</option>
										<option value="lab_assistant">Lab Assistant</option>
									</form:select>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label>Email Id</label> 
									<form:input type="text" class="form-control" path="loginId"
										placeholder="Email" required=""/>
								</div>
							</div>
							<div class="col-xs-4">
								<div class="form-group">
									<label>Password</label> 
									<form:input type="password" class="form-control" path="password"
										placeholder="Password" required=""/>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<a href="allusers.htm" class="btn btn-default">Cancel</a>
						<button type="submit" class="btn btn-success">Save</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</section>
<script>

function changeRoleSelect() {
    var x = document.getElementById("select_role").value;
    var elems = document.getElementsByClassName("clsHideStudent");
    var elemStaff = document.getElementsByClassName("clsHideStaff");
    if(x == "staff"){
    	for(var i=0;i<elems.length;i++){
    		elems[i].classList.add("hide");
    	}
    	for(var i=0;i<elemStaff.length;i++){
    		elemStaff[i].classList.remove("hide");
    	}
    	
    } else {
    	for(var i=0;i<elemStaff.length;i++){
    		elemStaff[i].classList.add("hide");
    	}
    	for(var i=0;i<elems.length;i++){
    		elems[i].classList.remove("hide");
    	}
    }
}
</script>