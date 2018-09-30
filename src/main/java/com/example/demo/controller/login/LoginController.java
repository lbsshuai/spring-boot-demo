package com.example.demo.controller.login;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.controller.common.NeoProperties;
import com.example.demo.dao.mapper.TblSysUserMapper;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.dao.vo.IndexVo;
import com.example.demo.service.ILoginService;

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
	 * 欢迎页
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		logger.info("进入欢迎页面");
		
		System.out.println(neo.getOne());
		System.out.println(neo.getTwo());
		TblSysUser user = new TblSysUser();
		user.setName("帅帅");
		user.setSex("男");
		loginService.insert(user);
		
		logger.info("访问结束,欢迎再来");
		return VIEW_PREFIX + "login";
	}
}
