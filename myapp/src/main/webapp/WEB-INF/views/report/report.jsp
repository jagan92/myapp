<%@ include file="/WEB-INF/views/include.jsp"%>
<section class="content-header">
	<h1>Search</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Report</li>
	</ol>
</section>


<section class="content">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped">
				<thead>
					<tr>
						<th style="width: 10%">#</th>
						<th>Date</th>
						<th>Absent Count</th>
						<th>Present Count</th>
						<th>Total Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dateReportVOs}" var="dateRep" varStatus="loop">
						<td>${loop.index + 1}</td>
						<td>
							
							<fmt:formatDate value="${dateRep.absentDate}" pattern="MM/dd/yyyy" var="parsedDate"/>
							${parsedDate }
						</td>
						<td>${dateRep.absentCount}</td>
						<td>${dateRep.presentCount}</td>
						<td>${dateRep.totalCount}</td>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>
