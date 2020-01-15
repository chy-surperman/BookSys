package com.vue.chy.Control;

import com.vue.chy.pojo.user;
import com.vue.chy.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import java.util.Objects;

@Controller
public class LoginControl {
    @CrossOrigin
   @PostMapping(value = "api/login")
   @ResponseBody
  public Result login(@RequestBody user requestUser){
        String username = requestUser.getUsername();
        username= HtmlUtils.htmlEscape(username);
      if(!Objects.equals("admin",username) && !Objects.equals(123456,requestUser.getPassword())){
          String message="账号密码错误";
          System.out.println("test测试404");
          return new Result(404);
      }else{
          System.out.println("测试");
          return  new Result(200);
      }
   }
}