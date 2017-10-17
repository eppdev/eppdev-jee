/*
 * FileName: MainController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-17
 */

package cn.eppdev.codegenerator.manager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fan.hao
 */
@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "redirect:/table/";
    }
}
