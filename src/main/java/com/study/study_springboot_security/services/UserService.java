package com.study.study_springboot_security.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.study_springboot_security.daos.SharedDao;
import com.study.study_springboot_security.utils.CommonUtils;

@Service
public class UserService {

    @Autowired
    SharedDao sharedDao;

    @Autowired
    CommonUtils commonUtils;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Object insert(Object dataMap) {
        String sqlMapId = "Memberwithauthority.insertWithUID";
        ((Map) dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map) dataMap).put("role", "ROLE_USER");

        // nomal to crypto
        String password = (String) ((Map) dataMap).get("password");
        ((Map) dataMap).put("password", bCryptPasswordEncoder.encode(password));
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

}
