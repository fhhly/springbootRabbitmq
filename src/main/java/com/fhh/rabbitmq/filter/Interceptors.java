package com.fhh.rabbitmq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Interceptors {
	@Bean
	public RemoteIpFilter ipFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.addInitParameter("paramName", "paramValue");
		registrationBean.setName("MyFilter");
		registrationBean.setOrder(1);
		return registrationBean;
	}

	public class MyFilter implements Filter {

		@Override
		public void init(FilterConfig filterConfig) throws ServletException {

		}

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest srequest = (HttpServletRequest) request;
			System.out.println("这是我的拦截器，请求接口为:" + srequest.getRequestURI());
			String ipA = (String) srequest.getHeader("X-Real-IP");
			System.out.println("请求的ip为:"+ipA);
			chain.doFilter(request, response);
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}

	}
}
