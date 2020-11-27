package com.ice.controller;


import com.ice.entity.NoticeEntity;
import com.ice.mapper.UserMapper;
import com.ice.service.NoticeService;
import com.ice.service.UserService;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController extends BaseApiService {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private UserService userService;

    @GetMapping("/success")
    public String success(Model model, @RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        model.addAttribute("check",userService.checkPermissions(loginname));
        return "noticeInfo";
    }

    @RequestMapping("/getAllNotice")
    @ResponseBody
    public BaseResponse getAllNotice(){
        List<NoticeEntity> allNotice = noticeService.getAllNotice();
        if(allNotice.size() > 0){
            return setResultSuccess(allNotice);
        }
        return setResultError("暂无公告");
    }

    @RequestMapping("/insert")
    @ResponseBody
    public BaseResponse insert(@RequestParam(value = "loginname", required = false) String loginname,
                                @RequestParam(value = "noticeContent", required = false) String noticeContent){
        boolean insert = noticeService.insert(noticeContent, loginname);
        if(insert){
            return setResultSuccess();
        }
        return setResultError("网络错误，请稍后重试！");
    }
}
