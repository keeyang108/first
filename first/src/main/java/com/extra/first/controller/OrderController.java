package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.pojo.*;
import com.extra.first.service.*;
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
    private OrderService orderService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private CarService carService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private VisitRecordService visitRecordService;


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
        String mediaName = request.getParameter("mediaName");
        logger.info("**************mediaName={}******************",mediaName);
        if (mediaName == null || StringUtils.isEmpty(mediaName)){
            BaseResult<Object> result = new BaseResult<Object>(false,"非法参数");
            json = new JSONPObject(callback,result);
            return json;
        }
        String terminal = request.getParameter("terminal");
        logger.info("**************terminal={}******************",terminal);
        OrderDetail detail = new OrderDetail(name,sex,mobile,province,
                city,agentName,Integer.parseInt(agentCode),carType,
                Integer.parseInt(carTypeCode),mediaName,terminal);
        int row = orderDetailService.insertOrder(detail);
        if (row < 1 ){
            logger.warn("****** Add order failed *************");
            return new JSONPObject(callback,new BaseResult<Object>(false,"Add failed"));
        }
        logger.info("*********name={},mobile={},province={},city={},agentName={},agentCode={},carType={},carTypeCode={},mediaName={},terminal={}",name,mobile,province,city,agentName,agentCode,carType,carTypeCode,mediaName,terminal);
        return new JSONPObject(callback,new BaseResult<Object>(true,"success"));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> addOrder(@ModelAttribute Order order) {
        if (StringUtils.isEmpty(order.getUserName())) {
            return new BaseResult<Object>(false, "用户名不能为空");
        }
        if (StringUtils.isEmpty(order.getUserPhone())) {
            return new BaseResult<Object>(false, "手机号不能为空");
        }
        if (!order.getUserPhone().matches("\\d{11}")) {
            return new BaseResult<Object>(false, "请输入正确的手机号码");
        }
        int row = orderService.addOrder(order);
        if (row < 1) {
            return new BaseResult<Object>(false, "Internal Error");
        }
        return new BaseResult<Object>(true, null);
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

    @RequestMapping(value = "/listcity", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List> listCity(Integer provinceId, Integer offset, Integer limit) {
        if (provinceId == null || provinceId <= 0) {
            return new BaseResult<List>(false, "非法参数");
        }
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<City> cities = cityService.queryCitiesByProvinceId(provinceId, (offset - 1) * limit, limit);
        return new BaseResult<List>(true, cities);
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

    @RequestMapping(value = "/listcar", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Car>> listCar(Integer currPage, Integer limit) {
        if (currPage == null || currPage <= 0) {
            currPage = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Car> cars = carService.listCar((currPage - 1) * limit, limit);
        if (cars == null || cars.size() < 1) {
            return new BaseResult<List<Car>>(false, "Internal Error");
        }
        return new BaseResult<List<Car>>(true, cars);
    }

    @RequestMapping(value = "/download")
    public String download(@ModelAttribute OrderDetail detail, HttpServletResponse response) {
        List<OrderDetail> result = null;
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        if (detail == null ){
            detail = new OrderDetail();
        }
        result = orderDetailService.listOrderDetails(detail,0,00);
        Map<String,Object> map   = null;
        for (OrderDetail detail1 : result){
           map  = new HashMap<String,Object>();
           map.put("name",detail.getAgentName());
            map.put("sex",detail.getSex());
            map.put("mobile",detail.getMobile());
            map.put("province",detail.getProvince());
            map.put("city",detail.getCity());
            map.put("agentName",detail.getAgentName());
            map.put("carType",detail.getCarType());
            map.put("mediaName",detail.getMediaName());
            map.put("createTime",detail.getCreateTime());
            list.add(map);
        }
        String[] titles = {"用户名", "性别","电话","省份", "城市","经销商" ,"车型","渠道","预约时间"};
        String[] keys = {"name", "sex","mobile", "province", "city", "agentName","carType","mediaName","createTime"};
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

    @RequestMapping(value = "/count")
    public void countVisit(HttpServletRequest req,HttpServletResponse res){
        res.setContentType("text/plain");
        String callbackFunName = req.getParameter("callback");//得到js函数名称
        String ip = req.getParameter("ip");

        try {
            if (StringUtils.isEmpty(ip)){
                res.getWriter().write(callbackFunName + "([{ data:"+"ip为空"+"}])"); //返回jsonp数据
            }
            int row = visitRecordService.addVisitRecord(ip);
            if (row > 0 )
            res.getWriter().write(callbackFunName + "([{ data:"+"success"+"}])"); //返回jsonp数据
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<PageBean<OrderDetail>> listOrder(@ModelAttribute OrderDetail orderDetail,Integer offset,Integer limit ){
        List<OrderDetail> details = null;
        int totalCount;
        if (orderDetail == null ){orderDetail = new OrderDetail();}
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
        return new BaseResult<PageBean<OrderDetail>>(true,pageBean);
    }
}
