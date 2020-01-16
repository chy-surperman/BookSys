package com.vue.chy.service;

import com.vue.chy.dao.UserDao;
import com.vue.chy.pojo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    @Autowired
    UserDao userDao;

    public boolean isExist(String username){
      user user= getByName(username);
        return  null!=user;
    }

    private user getByName(String username) {
        return  userDao.findByUsername(username);
    }

    public user  get(String username,String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(user user) {
        userDao.save(user);
    }

}
