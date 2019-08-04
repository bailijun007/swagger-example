package com.blj.controller;
import com.blj.pojo.Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@Api(tags = "hello相关的请求")
@RestController
@RequestMapping("/hello")
public class HelloController {

   @PutMapping
   @ApiImplicitParam(name = "username" ,value = "用户名")
    public String hello(String username){
        return "更新："+username+"用户信息！";
    }

    @DeleteMapping
    @ApiImplicitParam(name = "username" ,value = "用户名")
    public String Delete(String name){
        return "删除"+name+"成功！";
    }


}
