package com.example.demo.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.controller.mq.content.HelloSender;
import com.example.demo.dao.annotation.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author lbs
 * @date 2018年9月26日
 */
public class LoginInterceptor implements HandlerInterceptor{

	public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Autowired
	private HelloSender helloSender;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("登录拦截器");
		helloSender.send("shuai", "Come On Hello");
		//反射获取方法上的LoginRequred注解
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		LoginRequired loginRequired = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
		logger.info("登录注解:[{}]", loginRequired);
		if (loginRequired == null) {
			return true;
		}
		//有LoginRequired注解说明这个需要登录，提示用户登录
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print("您访问的接口需要登录");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle登录拦截器");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		//logger.info("afterCompletion拦截器");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}


}
