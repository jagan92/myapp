<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="animated flash mb25">
  <i class="ti-alert mr15 error-number"></i>
  <label class="error-heading">
    <fmt:message key="error_403_title" />
  </label>
</div>
<div class="mb25">
  <fmt:message key="error_403_text" />
</div>
<div class="mb25">
  <a href="home.htm" class="error-number">
    <i class="ti-home mr15"></i>
  </a>
</div>