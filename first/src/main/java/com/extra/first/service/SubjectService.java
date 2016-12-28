package com.extra.first.service;

import com.extra.first.pojo.Subject;

import java.util.List;

/**
 * Created by Kee on 2016/12/28.
 */
public interface SubjectService {

    //查询
    Subject getSubjectById(long subjectId);

    //更新viewCount;
    int updateViewCount(long subjectId);

    //增加
    int addSubject( Subject subject);

    //获取所有的Subject
    List<Subject> listSubjects(Subject subject, int offset, int limit);

}
