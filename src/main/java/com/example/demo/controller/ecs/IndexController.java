package com.example.demo.controller.ecs;

import com.example.demo.dao.vo.MenuList;
import com.example.demo.dao.vo.ResultParam;
import com.example.demo.dao.vo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lbs
 * @date 2019/5/23
 */
@Controller
@RequestMapping("/ecs/demo/")
public class IndexController {

    @RequestMapping(value = "getMenuList", method = RequestMethod.GET)
    @ResponseBody
    public ResultParam getMenulist(){
        //首页
        MenuList workspace = new MenuList();
        workspace.setMenuCode("worksapace");
        workspace.setMenuName("工作面板");
        workspace.setLeafMenu(false);
        workspace.setIcon("el-icon-s-home");
        MenuList homePage = new MenuList();
        homePage.setMenuCode("homePage");
        homePage.setMenuName("首页");
        homePage.setLeafMenu(true);
        MenuList personalCenter = new MenuList();
        personalCenter.setMenuCode("personalCenter");
        personalCenter.setMenuName("个人中心");
        personalCenter.setLeafMenu(true);
        List<MenuList> workspaceList = new ArrayList<>();
        workspaceList.add(homePage);
        workspaceList.add(personalCenter);
        workspace.setSubMenu(workspaceList);
        //移民业务
        MenuList immigrantBusiness = new MenuList();
        immigrantBusiness.setMenuCode("immigrant");
        immigrantBusiness.setMenuName("移民申请管理");
        immigrantBusiness.setLeafMenu(false);
        immigrantBusiness.setIcon("el-icon-document");
        MenuList immigrantMana = new MenuList();
        immigrantMana.setMenuCode("immigrantMana");
        immigrantMana.setMenuName("移民管理");
        immigrantMana.setLeafMenu(true);
        MenuList immigrantDrafts = new MenuList();
        immigrantDrafts.setMenuCode("immigrantDrafts");
        immigrantDrafts.setMenuName("草稿箱");
        immigrantDrafts.setLeafMenu(true);
        MenuList immigrantProMana = new MenuList();
        immigrantProMana.setMenuCode("immigrantProMana");
        immigrantProMana.setMenuName("移民项目管理");
        immigrantProMana.setLeafMenu(true);
        List<MenuList> immigrantList = new ArrayList<>();
        immigrantList.add(immigrantMana);
        immigrantList.add(immigrantDrafts);
        immigrantList.add(immigrantProMana);
        immigrantBusiness.setSubMenu(immigrantList);
        //客户管理
        MenuList customerMana = new MenuList();
        customerMana.setMenuCode("customer");
        customerMana.setMenuName("客户管理");
        customerMana.setLeafMenu(false);
        customerMana.setIcon("el-icon-s-custom");
        MenuList customerList = new MenuList();
        customerList.setMenuCode("customerList");
        customerList.setMenuName("客户列表");
        customerList.setLeafMenu(true);
        MenuList customerDrafts = new MenuList();
        customerDrafts.setMenuCode("customerDrafts");
        customerDrafts.setMenuName("草稿箱");
        customerDrafts.setLeafMenu(true);
        List<MenuList> custList = new ArrayList<>();
        custList.add(customerList);
        custList.add(customerDrafts);
        customerMana.setSubMenu(custList);
        //报表管理
        MenuList reportMana = new MenuList();
        reportMana.setMenuCode("report");
        reportMana.setMenuName("报表管理");
        reportMana.setLeafMenu(false);
        reportMana.setIcon("el-icon-location");
        MenuList immigrantApplyReport = new MenuList();
        immigrantApplyReport.setMenuCode("immigrantApplyReport");
        immigrantApplyReport.setMenuName("移民申请统计报表");
        immigrantApplyReport.setLeafMenu(true);
        List<MenuList> immigrantApplyReportList = new ArrayList<>();
        immigrantApplyReportList.add(immigrantApplyReport);
        reportMana.setSubMenu(immigrantApplyReportList);
        //系统管理
        MenuList systemMana = new MenuList();
        systemMana.setMenuCode("syste");
        systemMana.setMenuName("系统管理");
        systemMana.setLeafMenu(false);
        systemMana.setIcon("el-icon-s-operation");
        MenuList userMana = new MenuList();
        userMana.setMenuCode("userMana");
        userMana.setMenuName("用户管理");
        userMana.setLeafMenu(true);
        MenuList roleMana = new MenuList();
        roleMana.setMenuCode("roleMana");
        roleMana.setMenuName("角色管理");
        roleMana.setLeafMenu(true);
        MenuList privilegeMana = new MenuList();
        privilegeMana.setMenuCode("privilegeMana");
        privilegeMana.setMenuName("权限管理");
        privilegeMana.setLeafMenu(true);
        MenuList dictMana = new MenuList();
        dictMana.setMenuCode("dictMana");
        dictMana.setMenuName("字典管理");
        dictMana.setLeafMenu(true);
        MenuList safeMana = new MenuList();
        safeMana.setMenuCode("safeMana");
        safeMana.setMenuName("安全管理");
        safeMana.setLeafMenu(true);
        List<MenuList> manaList = new ArrayList<>();
        manaList.add(userMana);
        manaList.add(roleMana);
        manaList.add(privilegeMana);
        manaList.add(dictMana);
        manaList.add(safeMana);
        systemMana.setSubMenu(manaList);
        //最后list
        List<MenuList> finalMenuList = new ArrayList<>();
        finalMenuList.add(workspace);
        finalMenuList.add(immigrantBusiness);
        finalMenuList.add(customerMana);
        finalMenuList.add(reportMana);
        finalMenuList.add(systemMana);

        ResultParam resultParam = new ResultParam();
        resultParam.setData(finalMenuList);
        return resultParam;
    }

    @RequestMapping(value = "getCurrentUser", method = RequestMethod.GET)
    @ResponseBody
    public ResultParam getCurrentUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1");
        userInfo.setUserName("admin");
        ResultParam resultParam = new ResultParam();
        resultParam.setData(userInfo);
        return resultParam;
    }
}
