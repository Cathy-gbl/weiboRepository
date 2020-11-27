package com.ice.controller;


import com.ice.entity.UserEntity;
import com.ice.service.UserService;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/permissions")
public class PermissionsController extends BaseApiService {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/success")
    public String success(Model model, @RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        return "permissionsInfo";
    }

    @RequestMapping(value = "/getAllUser" , method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getAllUser(){
        List<UserEntity> allUser = userService.getAllUser();
        return setResultSuccess(allUser);
    }

    @RequestMapping(value = "/setPermissions" , method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse setPermissions(@RequestParam(value = "loginname", required = false) String loginname,
                                   @RequestParam(value = "flag", required = false) String flag){
        if(userService.setPermissions(loginname, flag)){
            return setResultSuccess();
        }
        return setResultError("网络异常，请稍后重试！");
    }
}
