package com.blj.controller;
import com.blj.pojo.Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Date;

@Api(tags = "用户相关的请求")
@RestController
@RequestMapping("/user")
public class DemoController {

   @GetMapping
   @ApiOperation("获取用户信息")
    public Demo getDemo(){
        Demo demo=new Demo();
        demo.setId(1);
        demo.setName("张三");
        demo.setRemarks("这是备注信息");
        demo.setCreatTime(new Date());
        return demo;
    }

    @PostMapping
    @ApiOperation("保存用户信息")
    public Demo saveDemo(@RequestHeader("token") String token, Demo demo){
       if(token.equals("123456")){
           return demo;
       } else{
            demo.setRemarks("没有登录，返回重新登录");
            demo.setCreatTime(new Date());
            demo.setName("null");
            demo.setId(0);
            return demo;
        }
    }

    @PutMapping
    @ApiOperation("更新用户信息")
   @ApiImplicitParams(
           {@ApiImplicitParam(name = "username",value = "用户名"),
             @ApiImplicitParam(name = "password",value = "密码")}
   )
    public String hello(String username,String password){
        return "更新用户信息！";
    }


}
