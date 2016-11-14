package com.extra.first.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Kee on 2016/11/7.
 */
@Aspect
@Component
public class SupervisorAop  {

    private static final Logger logger = LoggerFactory.getLogger(SupervisorAop.class);

}
