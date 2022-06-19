package chapter22.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;


//相当于web.xml
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//Spring ioc容器
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	//DispatcherServlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	//DispatcherServlet拦截内容
	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.do"};
	}

	@Override
	protected void customizeRegistration(Dynamic dynamic) {
		// 配置上传文件路径
		String filepath = "e:/mvc/uploads";
		// 5MB
		Long singleMax = (long) (5 * Math.pow(2, 20));
		// 10MB
		Long totalMax = (long) (10 * Math.pow(2, 20));
		// 设置上传文件配置
		dynamic.setMultipartConfig(new MultipartConfigElement(filepath, singleMax, totalMax, 0));

	}
}
