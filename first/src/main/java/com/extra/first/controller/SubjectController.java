package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.model.ResponseBuilder;
import com.extra.first.model.Subject;
import com.extra.first.model.SubjectQueryBean;
import com.extra.first.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author KeeYang on 2017/7/27.
 * @Description :
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public BaseResult<Boolean> addSubject(@RequestBody Subject subject){
        return ResponseBuilder.success(subjectService.addSubject(subject));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public BaseResult<Boolean> updateSubject(@RequestBody Subject subject){
        return ResponseBuilder.success(subjectService.updateSubjectByPKSelective(subject));
    }

    @RequestMapping(value = "/view",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public BaseResult<Subject> viewSubjectById(Integer id){
        return ResponseBuilder.success(subjectService.selectByPk(id));
    }

    @RequestMapping(value = "/del",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public BaseResult<Boolean> deleteByPK(Integer id){
        return ResponseBuilder.success(subjectService.deleteByPK(id));
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public BaseResult<List<Subject>> listSubject(@RequestBody SubjectQueryBean queryBean){
        return ResponseBuilder.success(subjectService.listSubject(queryBean));
    }

}
