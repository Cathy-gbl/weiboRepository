package com.ice.controller;


import com.ice.service.UserService;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController extends BaseApiService {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(@RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "password", required = false) String password,
                       Model model){
        boolean login = userService.login(username, password);
        if(login){
            return setResultSuccess();
        }
        return setResultError("登录名、密码不正确，请重新输入！");
    }

    @GetMapping("/success")
    public String success(Model model,@RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        model.addAttribute("check",userService.checkPermissions(loginname));
        return "login";
    }

    @GetMapping("/personalInfo")
    public String personalInfo(@RequestParam(value = "loginname", required = false) String loginname,Model model){
        model.addAttribute("loginname",loginname);
        return "personalInfo";
    }

    @RequestMapping(value = "/updateUserInfo" , method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updateUserInfo(@RequestParam(value = "username", required = false) String username,
                                       @RequestParam(value = "password", required = false) String password,
                                       @RequestParam(value = "age", required = false) Integer age,
                                       @RequestParam(value = "loginname", required = false) String loginname){

        int i = userService.updateUserInfo(username, password, age, loginname);
        if(i > 0){
            return setResultSuccess();
        }
        return setResultError("网络错误，请重新修改");
    }
}
