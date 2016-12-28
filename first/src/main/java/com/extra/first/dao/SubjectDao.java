package com.extra.first.dao;

import com.extra.first.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public interface SubjectDao {

        //查询
        Subject getSubjectById(long subjectId);

        //更新viewCount;
       int updateViewCount(long subjectId);

        //增加
       int addSubject(@Param("subject") Subject subject);

        //获取所有的Subject
       List<Subject> listSubjects(@Param("subject") Subject subject,@Param("offset") int offset, @Param("limit") int limit);
}
