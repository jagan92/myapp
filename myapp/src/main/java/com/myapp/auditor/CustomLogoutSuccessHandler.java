package com.myapp.auditor;

public class CustomLogoutSuccessHandler {
	 //implements LogoutSuccessHandler
//	@Autowired
//	HttpSession session;
//
//	// private static final Logger LOGGER = LogManager.getLogger();
//	private static final String CLASS_NAME = CustomLogoutSuccessHandler.class.getName();
//	private static final String FUNCTION_NAME = "onLogoutSuccess";
//
//	@Override
//	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			Authentication authentication) {
//		String contextPath = httpServletRequest.getContextPath();
//		ApplicationContext applicationContext = WebApplicationContextUtils
//				.getWebApplicationContext(httpServletRequest.getServletContext());
//		Properties applicationProperties = (Properties) applicationContext.getBean("applicationProperties");
//		httpServletRequest.getSession().invalidate();
//	}
}
