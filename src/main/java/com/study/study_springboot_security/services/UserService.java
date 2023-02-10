package com.study.study_springboot_security.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.study_springboot_security.daos.SharedDao;

public class UserService {

    @Autowired
    SharedDao sharedDao;

    public Object insert(Object dataMap) {
        String sqlMapId = "UserMapper.insertWithUID";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

}
