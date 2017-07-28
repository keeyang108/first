package com.extra.first.service.impl;

import com.extra.first.mapper.SubjectMapper;
import com.extra.first.model.Subject;
import com.extra.first.model.SubjectExample;
import com.extra.first.model.SubjectQueryBean;
import com.extra.first.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KeeYang on 2017/7/28.
 * @Description :
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    public boolean addSubject(Subject subject) {
        return subjectMapper.insertSelective(subject) > 0;
    }

    public boolean updateSubjectByPKSelective(Subject subject) {
        return subjectMapper.updateByPrimaryKeySelective(subject) > 0;
    }

    public List<Subject> listSubject(SubjectQueryBean queryBean) {
        SubjectExample example = new SubjectExample();
        SubjectExample.Criteria criteria = example.createCriteria();
        if (null  != queryBean){
//            if (queryBean)
        }


        return null;
    }

    public boolean deleteByPK(Integer subjectId) {
        return subjectMapper.deleteByPrimaryKey(subjectId) > 0;
    }

    public Subject selectByPk(Integer subjectId) {
        return subjectMapper.selectByPrimaryKey(subjectId);
    }
}
