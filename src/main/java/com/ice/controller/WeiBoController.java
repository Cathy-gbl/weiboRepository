package com.ice.controller;

import com.ice.entity.WeiBoEntity;
import com.ice.service.LabelService;
import com.ice.service.UserService;
import com.ice.service.WeiBoService;
import com.ice.utils.BaseApiService;
import com.ice.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/weibo")
public class WeiBoController extends BaseApiService {

    @Autowired
    private WeiBoService weiBoService;

    @Autowired
    private LabelService labelService;

    @Autowired
    private UserService userService;

    @RequestMapping("/success")
    public String success(Model model, @RequestParam(value = "loginname", required = false) String loginname){
        model.addAttribute("loginname",loginname);
        model.addAttribute("check",userService.checkPermissions(loginname));
        return "weiboInfo";
    }

    @RequestMapping(value = "/getWeiBoInfoByLoginname" , method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse getWeiBoInfoByLoginname(
                                       @RequestParam(value = "loginname", required = false) String loginname){

        List<WeiBoEntity> weiBoInfoByLoginname = weiBoService.getWeiBoInfoByLoginname(loginname);
        return setResultSuccess(weiBoInfoByLoginname);
    }

    @GetMapping("/delete")
    @ResponseBody
    @Transactional
    public BaseResponse delete(@RequestParam(value = "number", required = false) String number){
        boolean delete = weiBoService.delete(number);
        if(delete){
            return setResultSuccess();
        }
        return setResultError("网络异常，删除失败，请稍后再试！");
    }

    @RequestMapping("/getAllLabel")
    @ResponseBody
    public BaseResponse getAllLabel(){
       return setResultSuccess(labelService.getAllLabel());
    }

    @RequestMapping("/insert")
    @ResponseBody
    @Transactional
    public BaseResponse insert(@RequestParam(value = "content", required = false) String content,
                               @RequestParam(value = "tital", required = false) String tital,
                               @RequestParam(value = "labelname", required = false) String labelname,
                               @RequestParam(value = "loginname", required = false) String loginname){
        boolean insert = weiBoService.insert(content,tital,labelname,loginname);
        if(insert){
            return setResultSuccess();
        }
        return setResultError("网络异常，请稍后再试！");
    }
}
