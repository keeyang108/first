package com.extra.first.dao;

import com.extra.first.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface SubjectDao {

        //查询
        Subject getSubjectById(long subjectId);

        //更新viewCount;
       int updateViewCount(Subject subject);

        //增加
       int addSubject(Subject subject);

        //获取所有的Subject
       List<Subject> listSubjects(@Param("offset") int offset, @Param("limit") int limit);
}
