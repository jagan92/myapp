<!doctype html>
<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<%--<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" /> --%>

</head>
<body class="bg-danger">
  <tiles:insertAttribute name="header" />
  <div class="center-wrapper">
    <div class="center-content text-center">
      <tiles:insertAttribute name="body" />
      <ul class="mt25 error-nav">
<!--         <li> -->
<%--           <tiles:insertAttribute name="footer" /> --%>
<!--         </li> -->
      </ul>
    </div>
  </div>
  <script src="resources/plugins/jquery-1.11.1.min.js"></script>
  <script src="resources/bootstrap/js/bootstrap.min.js"></script>
  <script src="resources/plugins/toastr/toastr.min.js"></script>
  <script src="resources/js/common.js"></script>
  <script src="resources/plugins/jstree/jstree.min.js"></script>
</body>
</html>