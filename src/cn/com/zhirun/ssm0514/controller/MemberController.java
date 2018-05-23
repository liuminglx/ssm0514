package cn.com.zhirun.ssm0514.controller;

import cn.com.zhirun.ssm0514.model.MemberModel;
import cn.com.zhirun.ssm0514.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@RequestMapping("/member")
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/selectById")
    public ModelAndView selectByPrimaryKey(String id) {

        MemberModel memberModel = memberService.selectByPrimaryKey(id);

        ModelAndView mv = new ModelAndView();
        mv.addObject("member", memberModel);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/selectByMember")
    public ModelAndView selectByPrimaryKey(MemberModel member) {

        MemberModel memberModel = memberService.selectByPrimaryKey(member.getId());

        ModelAndView mv = new ModelAndView();
        mv.addObject("member", memberModel);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/toResult")
    public String toResult() {

        return "result";
    }

    @ResponseBody
    @RequestMapping("/selectByAjax")
    public MemberModel selectByAjax(String id) {
        MemberModel memberModel = memberService.selectByPrimaryKey(id);
        return memberModel;
    }

    @ResponseBody
    @RequestMapping("/selectByAjaxBetter")
    public ModelMap selectByAjaxBetter(String id, HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ModelMap modelMap = new ModelMap();
        MemberModel memberModel = memberService.selectByPrimaryKey(id);
        // 放到 ModelMap 里
        modelMap.put("member", memberModel);
        return modelMap;
    }

    @RequestMapping("/deleteById")
    public String deleteByPrimaryKey(String id) {
        int num = memberService.deleteByPrimaryKey(id);
        if (num != 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/insertMember")
    public String insert(MemberModel record) {
        int num = memberService.insert(record);
        if (num != 0) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/selectMembers")
    public ModelAndView selectMembers(MemberModel memberModel) {

        ModelAndView mv = new ModelAndView();
        List<MemberModel> list = memberService.selectMembers(memberModel);
        mv.addObject("members", list);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/selectByIds")
    public ModelAndView selectByIds(String[] id) {
        ModelAndView mv = new ModelAndView();
        List<MemberModel> list = memberService.selectByIds(id);
        mv.addObject("members", list);
        mv.setViewName("result");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/selectByIdsAjax")
    public ModelMap selectByIdsAjax(@RequestParam("id[]") String[] id) {
        ModelMap mm = new ModelMap();
        List<MemberModel> list = memberService.selectByIds(id);
        mm.put("members", list);
        return mm;
    }

    @RequestMapping("/testLanguage")
    public ModelAndView testLanguage(String username, Locale locale) {

        Object[] objects = new Object[1];
        objects[0] = username;
        String result = applicationContext.getMessage("login", objects, locale);

        ModelAndView memberModel = new ModelAndView();
        memberModel.addObject("result", result);
        memberModel.setViewName("result");

        return memberModel;
    }

    @RequestMapping("/changeLanguage")
    public String changeLanguage() {
        return "forward:/testLanguage.jsp";
    }
}
