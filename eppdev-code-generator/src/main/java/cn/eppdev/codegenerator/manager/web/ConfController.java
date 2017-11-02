/*
 * FileName: ConfController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-11-01
 */

package cn.eppdev.codegenerator.manager.web;

import cn.eppdev.codegenerator.manager.entity.EppdevConf;
import cn.eppdev.codegenerator.manager.service.EppdevConfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author fan.hao
 */
@Controller
@RequestMapping("/conf")
public class ConfController {

    @Autowired
    EppdevConfService confService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", confService.listAll().getList());
        return "conf/list";
    }

    @RequestMapping("/save")
    public String save(EppdevConf conf, RedirectAttributes redirectAttributes){
        try {
            confService.save(conf);
            redirectAttributes.addFlashAttribute("message", "保存成功");
        }catch (Exception e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "保存失败");
        }
        return "redirect:/conf/list";
    }
}
