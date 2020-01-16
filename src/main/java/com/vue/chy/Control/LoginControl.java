package com.vue.chy.Control;

import com.vue.chy.pojo.user;
import com.vue.chy.service.userservice;
import com.vue.chy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;


@Controller
public class LoginControl {
    @Autowired
    userservice userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody user requestUser, HttpSession session) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        user user = userService.get(username, requestUser.getPassword());
        if (null != user) {
            session.setAttribute("user",user);
            return new Result(200);
        } else {
            return new Result(400);
        }
    }
}