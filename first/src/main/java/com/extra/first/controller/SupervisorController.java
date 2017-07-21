package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.pojo.Supervisor;
import com.extra.first.service.SupervisorService;
import com.extra.first.util.JwtTokenManagement;
import com.extra.first.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Kee on 2016/10/30.
 */
@Api(value = "Supervisor",description = "Supervisor",tags = {"Supervisor"})
@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

    private final static Logger logger = LoggerFactory.getLogger(SupervisorController.class);

    @Autowired
    private SupervisorService supervisorService;

    private JwtTokenManagement jwtTokenUtils;

    @RequestMapping(value = "/user/add",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> addSupervisor(@ModelAttribute Supervisor supervisor, HttpServletRequest request, @RequestParam("textfile")CommonsMultipartFile upfile) throws IOException {

        String path = request.getRealPath("/WEB-INF/upload");
        File file = null;
        if (!upfile.isEmpty()){
            file =  new File(path,"head_"+upfile.getOriginalFilename());
            byte[] bytes = upfile.getBytes();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(bytes);
            bos.close();
        }

        if (StringUtils.isEmpty(supervisor.getSupervisorName())){
            return new BaseResult<Object>(false,"用户名不能为空");
        }
        if (StringUtils.isEmpty(supervisor.getSupervisorPhone()) || !supervisor.getSupervisorPhone().matches("\\d{11}"))   {
             return new BaseResult<Object>(false,"请输入正确格式的手机号码");
        }
        if (StringUtils.isEmpty(supervisor.getPassword())){
            return new BaseResult<Object>(false,"请输入密码");
        }
        if (file != null){
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            System.out.println(file.getName());
            supervisor.setHeadImagePath(file.getPath());
        }

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

    @ApiOperation("user login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名",dataType = "string",paramType = "query"),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "string",paramType = "query")
    })
    @RequestMapping(value = "/logining",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> login(String userName, String password, HttpServletRequest request, HttpServletResponse response){
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
        String token = jwtTokenUtils.generateToken(supervisor);
        JwtUtils.setCookie(request,response,token);
        return new BaseResult<Object>(true,"success");
    }

    @ApiOperation("user loginout")
    @RequestMapping(value = "/loginout",method = RequestMethod.PUT)
    public String loginout(HttpServletRequest request,HttpServletResponse response){
        cleanCookie(request,response);
        return "/supervisor/login";
    }

    private void cleanCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                cookies[i].setDomain(request.getServerName());
                cookies[i].setValue(null);
                cookies[i].setPath("/");
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
            }
        }
    }
}
