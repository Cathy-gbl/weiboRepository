package com.ice.controller;


import com.ice.entity.CommonOptionEntity;
import com.ice.service.CommonOptionService;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonOptionController extends BaseApiService {

    @Autowired
    private CommonOptionService commonOptionService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/getHotContent")
    @ResponseBody
    public BaseResponse getHotContent() {
        List<CommonOptionEntity> hotContentOption = commonOptionService.getHotContentOption();
        return setResultSuccess(hotContentOption);
    }

    @RequestMapping(value = "/getHotContentByLike", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getHotContentByLike(@RequestParam(value = "hotContent", required = false) String hotContent) {
        if (StringUtils.isEmpty(hotContent)) {
            return setResultError("输入内容不能为空！");
        }
        List<CommonOptionEntity> hotContentOption = commonOptionService.getHotContentOptionByLike(hotContent);
        return setResultSuccess(hotContentOption);
    }

    @GetMapping("/hotContentXq")
    public String hotContentXq(Model model, @RequestParam(value = "params", required = false) String params,
                               @RequestParam(value = "loginname", required = false) String loginname) {
        List<CommonOptionEntity> hotContentXqByNumber = commonOptionService.getHotContentXqByNumber(params);
        for (CommonOptionEntity commonOptionEntity : hotContentXqByNumber) {
            model.addAttribute("number",commonOptionEntity.getNumber());
            model.addAttribute("tital",commonOptionEntity.getTital());
            model.addAttribute("username",commonOptionEntity.getUsername());
            model.addAttribute("createDate",commonOptionEntity.getCreateDate());
            model.addAttribute("content",commonOptionEntity.getContent());
        }
        List<CommonOptionEntity> hotCommentsXqByNumber = commonOptionService.getHotCommentsXqByNumber(params);
        model.addAttribute("comments",hotCommentsXqByNumber);

        if(loginname==null){

            model.addAttribute("check",false);
        }else {
            model.addAttribute("loginname",loginname);
            model.addAttribute("check",true);
        }

        return "templates";
    }


}
