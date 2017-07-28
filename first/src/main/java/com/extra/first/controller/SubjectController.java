package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
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

    @PostMapping("/add")
    public BaseResult<Boolean> addSubject(@RequestBody Subject subject){
        return new BaseResult<Boolean>(true,subjectService.addSubject(subject));
    }

    @PostMapping("update")
    public BaseResult<Boolean> updateSubject(@RequestBody Subject subject){
        return new BaseResult<Boolean>(true,subjectService.updateSubjectByPKSelective(subject));
    }

    @GetMapping("view")
    public BaseResult<Subject> viewSubjectById(Integer id){
        return new BaseResult<Subject>(true,subjectService.selectByPk(id));
    }

    @DeleteMapping("del")
    public BaseResult<Boolean> deleteByPK(Integer id){
        return new BaseResult<Boolean>(true,subjectService.deleteByPK(id));
    }

    @GetMapping("list")
    public BaseResult<List<Subject>> listSubject(@RequestBody SubjectQueryBean queryBean){
        return new BaseResult<List<Subject>>(true,subjectService.listSubject(queryBean));
    }

}
