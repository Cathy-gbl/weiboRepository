package com.ice.controller;

import com.ice.entity.CommentsEntity;
import com.ice.entity.WeiBoEntity;
import com.ice.service.CommentsSerive;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentsController extends BaseApiService {

    @Autowired
    private CommentsSerive commentsSerive;

    @RequestMapping("/success")
    public String success(Model model, @RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        return "commentsInfo";
    }

    @RequestMapping(value = "/getCommentsInfoByLoginName" , method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getCommentsInfoByLoginName(
            @RequestParam(value = "loginname", required = false) String loginname){
        List<CommentsEntity> commentsInfoByLoginName = commentsSerive.getCommentsInfoByLoginName(loginname);
        return setResultSuccess(commentsInfoByLoginName);
    }

    @GetMapping("/delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam(value = "number", required = false) String number){
        boolean delete = commentsSerive.delete(number);
        if(delete){
            return setResultSuccess();
        }
        return setResultError("网络异常，删除失败，请稍后再试！");
    }
}
