package com.vue.chy.dao;

import com.vue.chy.pojo.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<user,Integer> {
    user findByUsername(String username);

    user getByUsernameAndPassword(String username,String password);
}
