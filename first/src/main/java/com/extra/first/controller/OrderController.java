package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.model.OrderDetailQueryBean;
import com.extra.first.pojo.Agency;
import com.extra.first.pojo.OrderDetail;
import com.extra.first.pojo.PageBean;
import com.extra.first.pojo.Province;
import com.extra.first.service.AgencyService;
import com.extra.first.service.OrderDetailService;
import com.extra.first.service.ProvinceService;
import com.extra.first.util.ExcelUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/10/23.
 */
@Controller
@RequestMapping("/front/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private OrderDetailService orderDetailService;
    
    @RequestMapping(value = "/append",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONPObject addOrderByJSONP(String callback,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
        JSONPObject json = null;
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        if (name == null || StringUtils.isEmpty(name.toString())){
            BaseResult<Object> result = new BaseResult<Object>(false,"用户名不能为空");
            json = new JSONPObject(callback,result);
            return json;
        }
        logger.info("**************name={}******************",name);
        String sex = request.getParameter("sex");
        logger.info("**************sex={}******************", sex);
        if (sex == null || StringUtils.isEmpty(sex.toString())){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String mobile = request.getParameter("mobile");
        logger.info("**************mobile={}******************",mobile);
        if (mobile == null || StringUtils.isEmpty(mobile)|| !mobile.matches("\\d{11}")) {
            BaseResult<Object> result = new BaseResult<Object>(false,"请输入正确的手机号码");
            json = new JSONPObject(callback,result);
            return json;
        }
        String province = request.getParameter("province");
        logger.info("**************province={}******************",province);
        if (province == null || StringUtils.isEmpty(province)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String city = request.getParameter("city");
        logger.info("**************city={}******************",city);
        if (city == null || StringUtils.isEmpty(city)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String agentName = request.getParameter("agentName");
        logger.info("**************agentName={}******************",agentName);
        if (agentName == null || StringUtils.isEmpty(agentName)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String agentCode = request.getParameter("agentCode");
        logger.info("**************agentCode={}******************",agentCode);
        if (agentCode == null || StringUtils.isEmpty(agentCode) || Integer.parseInt(agentCode)< 0 || !agentCode.matches("\\d")){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String carType = request.getParameter("carType");
        logger.info("**************carType={}******************",carType);
        if (carType == null || StringUtils.isEmpty(carType)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String carTypeCode = request.getParameter("carTypeCode");
        logger.info("**************carTypeCode={}******************",carTypeCode);
        if (carTypeCode == null || StringUtils.isEmpty(carTypeCode) || Integer.parseInt(carTypeCode)< 0 || !carTypeCode.matches("\\d")){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String mediaName = URLDecoder.decode(request.getParameter("mediaName"), "utf-8");
        logger.info("**************mediaName={}******************",mediaName);
        if (mediaName == null || StringUtils.isEmpty(mediaName)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String mediaUrl = URLDecoder.decode(request.getParameter("mediaUrl"), "utf-8");
        logger.info("**************mediaUrl={}******************",mediaUrl);
        if (mediaUrl == null || StringUtils.isEmpty(mediaUrl)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String subject = request.getParameter("subject");
        logger.info("*************subject={}*******************",subject);
        String terminal = request.getParameter("terminal");
        logger.info("**************terminal={}******************",terminal);
        int isActivity = request.getParameter("isActivity") == null ? 0:1;
        OrderDetail detail = new OrderDetail(name,sex,mobile,province,
                city,agentName,Integer.parseInt(agentCode),carType,
                Integer.parseInt(carTypeCode),mediaName,terminal,subject,isActivity,mediaUrl);
        int row = orderDetailService.insertOrder(detail);
        if (row < 1 ){
            logger.warn("****** Add order failed *************");
            return new JSONPObject(callback,new BaseResult<Object>(false,"Add failed"));
        }
        logger.info("*********name={},mobile={},province={},city={},agentName={},agentCode={},carType={},carTypeCode={},mediaName={},terminal={},subject={}",name,mobile,province,city,agentName,agentCode,carType,carTypeCode,mediaName,terminal,subject);
        return new JSONPObject(callback,new BaseResult<Object>(true,"success"));
    }


    @RequestMapping(value = "/listprovince", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Province>> listProvince(Integer offset, Integer limit) {
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Province> provinces = provinceService.listProvince((offset - 1) * limit, limit);
        if (provinces == null || provinces.size() < 1) {
            return new BaseResult<List<Province>>(false, "Internal Error");
        }
        return new BaseResult<List<Province>>(true, provinces);
    }

    @RequestMapping(value = "/listagency", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Agency>> listAgency(Integer cityId, Integer offset, Integer limit) {
        if (cityId == null || cityId <= 0) {
            return new BaseResult<List<Agency>>(false, "非法参数");
        }
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Agency> agencies = agencyService.queryAgenciesByCityId(cityId, (offset - 1) * limit, limit);
        if (agencies == null || agencies.size() < 1) {
            return new BaseResult<List<Agency>>(false, "Internal Error");
        }
        return new BaseResult<List<Agency>>(true, agencies);
    }
    
    @RequestMapping(value = "/download")
    public String download(@ModelAttribute OrderDetailQueryBean detail, HttpServletResponse response) {
        List<OrderDetail> result = null;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        if( detail != null && StringUtils.isEmpty(detail.getSubject())){
            return null;
        }
        if (detail == null ){
            detail = new OrderDetailQueryBean();
        }
        detail.setIsActivity(false);
        logger.info(detail.toString());
        result = orderDetailService.listOrderDetails(detail,0,10000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (OrderDetail orderDetail : result){
            Map<String,Object> map  = new HashMap<String,Object>();
            map.put("name",orderDetail.getName());
            map.put("sex",orderDetail.getSex());
            map.put("mobile",orderDetail.getMobile());
            map.put("province",orderDetail.getProvince());
            map.put("city",orderDetail.getCity());
            map.put("agentName",orderDetail.getAgentName());
            map.put("carType",orderDetail.getCarType());
            map.put("mediaName",orderDetail.getMediaName());
            map.put("createTime",dateFormat.format(orderDetail.getCreateTime()));
            map.put("mediaUrl",orderDetail.getMediaUrl());
            list.add(map);
        }
        String[] titles = {"用户名", "性别","电话","省份", "城市","经销商" ,"车型","渠道","渠道链接","预约时间"};
        String[] keys = {"name", "sex","mobile", "province", "city", "agentName","carType","mediaName","mediaUrl","createTime"};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            ExcelUtil.createExcel("预约表", titles, keys, list).write(os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(("预约表.xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int byteRead;
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<PageBean<OrderDetail>> listOrder(@ModelAttribute OrderDetailQueryBean orderDetail, Integer offset, Integer limit ){
        List<OrderDetail> details = null;
        int totalCount;
        if (orderDetail == null ){orderDetail = new OrderDetailQueryBean();}
        if (offset == null || offset < 1 ){
           offset = 1;
        }
        if (limit == null || limit < 1 ){
            limit =10;
        }
        try {
            details = orderDetailService.listOrderDetails(orderDetail,(offset-1)*limit,limit);
            totalCount = orderDetailService.countOrderDetails(orderDetail);
        } catch (DataAccessException e) {
            logger.error("***************获取预约订单失败，错误信息{}",e.getCause().getMessage());
            return  new BaseResult<PageBean<OrderDetail>>(false,"内部错误，请联系管理员");
        }
        if (details == null || details.size() < 1){
            return new BaseResult<PageBean<OrderDetail>>(false,"内部错误，请联系管理员");
        }
        PageBean<OrderDetail> pageBean =  new PageBean<OrderDetail>();
        pageBean.setCurrPage(offset);
        pageBean.setPageSize(limit);
        pageBean.setData(details);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalCount/limit);
        Map<String,Object> conditions = new HashMap<String,Object>();
        if (orderDetail.getStartDate() != null ){
            conditions.put("startDate",orderDetail.getStartDate());
        }
        if(orderDetail.getEndDate()!=null){
            conditions.put("endDate",orderDetail.getEndDate());
        }
        if (!StringUtils.isEmpty(orderDetail.getSubject())) {
            conditions.put("subject",orderDetail.getSubject());
        }
        pageBean.setConditions(conditions);
        return new BaseResult<PageBean<OrderDetail>>(true,pageBean);
    }

    @RequestMapping(value = "/activity/download")
    public String activityDownload(@ModelAttribute OrderDetailQueryBean detail, HttpServletResponse response) {
        List<OrderDetail> result = null;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        if (detail == null ){
            detail = new OrderDetailQueryBean();
        }
        detail.setIsActivity(true);
        result = orderDetailService.listOrderDetails(detail,0,10000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (OrderDetail orderDetail : result){
            Map<String,Object> map  = new HashMap<String,Object>();
            map.put("name",orderDetail.getName());
            map.put("mobile",orderDetail.getMobile());
            map.put("city",orderDetail.getCity());
            map.put("subject",orderDetail.getSubject());
            map.put("createTime",dateFormat.format(orderDetail.getCreateTime()));
            list.add(map);
        }
        String[] titles = {"用户名","电话", "城市","活动专题","预约时间"};
        String[] keys = {"name","mobile", "city","subject","createTime"};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            ExcelUtil.createExcel("预约表", titles, keys, list).write(os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + new String(("活动参与表.xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();

            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int byteRead;
            while (-1 != (byteRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, byteRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
