package com.example.demo.controller.login;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.dao.model.TblSysUser;
import com.fasterxml.jackson.databind.deser.impl.NullsAsEmptyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.common.NeoProperties;
import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.util.JsonResult;
import com.example.demo.service.ILoginService;
import com.octo.captcha.service.CaptchaServiceException;

@Controller
public class LoginController {

	private static final String VIEW_PREFIX = "login/";
	
	@Autowired
	private NeoProperties neo;
	
	@Autowired
	private ILoginService loginService;
	
	//日志
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 首页面
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		logger.info("进入首页");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 进入优选商品首页
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return VIEW_PREFIX + "login";
	}
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return VIEW_PREFIX + "register";
	}
 	
	/**
	 * 登录服务
	 * @param request
	 * @param response
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/loginIn", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult loginIn(HttpServletRequest request, HttpServletResponse response,
							  @RequestParam(value = "name") String name,
							  @RequestParam(value = "password") String password,
							  @RequestParam(value = "rememberMe") String rememberMe){
		logger.info("登录参数：name：" + name + "|||password:" + password);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setFlag("success");

		try {
			loginService.loginIn(name, password, rememberMe, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
			if(e instanceof MyException){
				jsonResult.setMessage(e.getMessage());
			}else {
				jsonResult.setMessage("登录失败");
			}
			jsonResult.setFlag("fail");
		}

		return jsonResult;
	}

	/**
	 * 注册服务
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult signIn(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute TblSysUser user) {
		logger.info("用户参数:" + user.toString());
		
		JsonResult result = new JsonResult();
		result.setFlag("success");
		
		try {
			loginService.signIn(user);
		} catch (Exception e) {
			if(e instanceof MyException) {
				result.setMessage(e.getMessage());
			} else {
				result.setMessage("注册任务异常");
			}
			result.setFlag("fail");
		}
		
		return result;
	}
	
	/**
	 * 验证码生成
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws IOException
	 */
	@RequestMapping("/login/jcaptcha")
	public void getJcaptchas(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		byte[] captchaBytes = null;
		ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
		try {
			String captchaId = httpServletRequest.getSession().getId();
			BufferedImage challenge = com.example.demo.dao.util.CaptchaServiceSingleton.getInstance().getImageChallengeForID(captchaId, httpServletRequest.getLocale());
			ImageIO.write(challenge, "png", imgOutputStream);
			captchaBytes = imgOutputStream.toByteArray();
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		} catch (CaptchaServiceException e) {
			logger.error(e.getMessage(), e);
			httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return;
		}
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaBytes);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
}
