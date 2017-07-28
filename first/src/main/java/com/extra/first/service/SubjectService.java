package com.extra.first.service;

import com.extra.first.model.Subject;
import com.extra.first.model.SubjectQueryBean;

import java.util.List;

/**
 * @author KeeYang on 2017/7/27.
 * @Description :
 */
public interface SubjectService {

    /**
     * add subject
     * @param subject
     * @return
     */
    boolean addSubject(Subject subject);

    /**
     * update subject by pk
     * @param subject
     * @return
     */
    boolean updateSubjectByPKSelective(Subject subject);

    /**
     * list subject
     * @return
     */
    List<Subject> listSubject(SubjectQueryBean queryBean);

    /**
     * delete by pk
     * @param subjectId
     * @return
     */
    boolean deleteByPK(Integer subjectId);

    /**
     * select by pk
     * @param subjectId
     * @return
     */
    Subject selectByPk(Integer subjectId);
}
