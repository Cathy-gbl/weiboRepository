package com.ice.controller;

import com.ice.entity.CommentsEntity;
import com.ice.service.LabelService;
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
@RequestMapping("/label")
public class LabelController extends BaseApiService {

    @Autowired
    private LabelService labelService;

    @RequestMapping("/success")
    public String success(Model model, @RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        return "labelInfo";
    }

    @RequestMapping(value = "/insert" , method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getCommentsInfoByLoginName(
            @RequestParam(value = "loginname", required = false) String loginname,
            @RequestParam(value = "labelname", required = false) String labelname){
        if(labelService.insert(labelname,loginname)){
            return setResultSuccess();
        }
        return setResultError("网络异常，请稍后重试！");
    }
}
