package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.pojo.Supervisor;
import com.extra.first.service.SupervisorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Kee on 2016/10/30.
 */
@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

    private final static Logger logger = LoggerFactory.getLogger(SupervisorController.class);
    @Autowired
    private SupervisorService supervisorService;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> addSupervisor(@ModelAttribute Supervisor supervisor){

        if (StringUtils.isEmpty(supervisor.getSupervisorName())){
            return new BaseResult<Object>(false,"用户名不能为空");
        }
        if (StringUtils.isEmpty(supervisor.getSupervisorPhone()) || !supervisor.getSupervisorPhone().matches("\\d{11}"))   {
             return new BaseResult<Object>(false,"请输入正确格式的手机号码");
        }
        if (StringUtils.isEmpty(supervisor.getPassword())){
            return new BaseResult<Object>(false,"请输入密码");
        }
        supervisor.setPassword(supervisor.getPassword());
        int row = supervisorService.addSupervisor(supervisor);
        if (row < 1 ){
            return new BaseResult<Object>(false,"Internal Error");
        }
        return new BaseResult<Object>(true,"添加成功");

    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("user") ==  null ){
            return "/supervisor/login";
        }
        return "/supervisor/home";
    }


    @RequestMapping(value = "/logining",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> login(String userName, String password, HttpServletRequest request){
        if (StringUtils.isEmpty(userName)){
            return new BaseResult<Object>(false,"请输入用户名");
        }
        if (StringUtils.isEmpty(password)){
            return new BaseResult<Object>(false,"请输入密码");
        }
        Supervisor supervisor = new Supervisor();
        supervisor.setSupervisorName(userName);
        supervisor.setPassword(password);
        Map<String,Object> result = supervisorService.checkUser(supervisor);
        if (result == null ){
            return new BaseResult<Object>(false,"用户名或密码错误");
        }
        request.getSession().setAttribute("user",userName);
        request.getSession().setMaxInactiveInterval(1800);
        return new BaseResult<Object>(true,"success");
    }

}
