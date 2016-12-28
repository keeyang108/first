package com.extra.first.dao;

import com.extra.first.pojo.Subject;
import com.sun.org.apache.xml.internal.utils.SuballocatedByteVector;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-*.xml"})
public class SubjectDaoTest {

    @Autowired
    private SubjectDao subjectDao;

    @Ignore
    @Test
    public void getSubjectById() throws Exception {
        Subject subject =  subjectDao.getSubjectById(1);
        Assert.assertEquals("1",subject.getId().toString());
    }

    @Test
    public void updateViewCount() throws Exception {
       int row =  subjectDao.updateViewCount(1);
        Assert.assertEquals(1,row);
    }

    @Ignore
    @Test
    public void addSubject() throws Exception {
        Subject subject = new Subject();
        subject.setName("大迈X7嘉年华专题2");
        subject.setUrl("http://112.74.16.209");
        subject.setDescription("this is a subject for x7");
        int row = subjectDao.addSubject(subject);
        Assert.assertEquals(1,row);
    }

    @Test
    public void listSubjects() throws Exception {
        List<Subject> subjects = subjectDao.listSubjects(new Subject(),0,10);
        Assert.assertEquals(3,subjects.size());
    }

}