package com.extra.first.service.impl;

import com.extra.first.dao.SubjectDao;
import com.extra.first.pojo.Subject;
import com.extra.first.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kee on 2016/12/28.
 */
@Service
public class SubjectServiceImpl implements SubjectService{

    private static final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Autowired
    private SubjectDao subjectDao;

    public Subject getSubjectById(long subjectId) {
        return null;
    }

    public int updateViewCount(long subjectId) {
        return subjectDao.updateViewCount(subjectId);
    }

    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    public List<Subject> listSubjects(Subject subject, int offset, int limit) {
        return subjectDao.listSubjects(subject,offset,limit);
    }
}
