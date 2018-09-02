<%@ include file="/WEB-INF/views/include.jsp"%>
<section class="content-header">
	<h1>
		Add User 
	</h1>
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
	            <div class="box-body">
	              <div class="row">
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>User Type</label>
		                  <select class="form-control">
		                    <option>Student</option>
<!-- 		                    <option>Staff</option> -->
<!-- 		                    <option>Admin</option> -->
		                  </select>
		                </div>
	                </div>
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>First Name</label>
		                  <input type="text" class="form-control" placeholder="Enter ...">
		                </div>
	                </div>
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Last Name</label>
		                  <input type="text" class="form-control" placeholder="Enter ...">
		                </div>
	                </div>
	              </div>
	              <div class="row">
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Department</label>
		                  <select class="form-control">
		                    <option>Department 1</option>
		                    <option>Department 2</option>
		                    <option>Department 3</option>
<!-- 		                    <option>Staff</option> -->
<!-- 		                    <option>Admin</option> -->
		                  </select>
		                </div>
	                </div>
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Course</label>
		                  <select class="form-control">
		                    <option>Course 1</option>
		                    <option>Course 2</option>
		                    <option>Course 3</option>
		                  </select>
		                </div>
	                </div>
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Section</label>
		                  <select class="form-control">
		                    <option>A</option>
		                    <option>B</option>
		                    <option>C</option>
		                  </select>
		                </div>
	                </div>
	              </div>
	              <div class="row">
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Email Id</label>
		                  <input type="text" class="form-control" placeholder="Enter ...">
		                </div>
	                </div>
	                <div class="col-xs-4">
	                   <div class="form-group">
		                  <label>Password</label>
		                  <input type="text" class="form-control" placeholder="Enter ...">
		                </div>
	                </div>
	              </div>
	            </div>
	            <!-- /.box-body -->
	            <div class="box-footer">
	                <button type="button" class="btn btn-default">Cancel</button>
	                <button type="button" class="btn btn-success">Save</button>
	              </div>
	          </div>
		</div>
	</div>
</section>
