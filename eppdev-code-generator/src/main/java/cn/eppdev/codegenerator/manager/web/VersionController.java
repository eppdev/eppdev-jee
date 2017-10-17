/*
 * FileName: VersionController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-12
 */

package cn.eppdev.codegenerator.manager.web;

import cn.eppdev.codegenerator.manager.entity.EppdevVersion;
import cn.eppdev.codegenerator.manager.service.EppdevVersionService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author fan.hao
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    private static Logger logger = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    EppdevVersionService versionService;

    @RequestMapping(path = {"/"})
    public String list(Model model){
        PageInfo<EppdevVersion> pageInfo = versionService.listAll();
        logger.debug("pageInfo: {}", pageInfo);
        model.addAttribute("list", versionService.listAll().getList());
        return "version/list";
    }

    @RequestMapping("/add/to")
    public String toAdd(Model model){
        PageInfo<EppdevVersion> pageInfo = versionService.listAll();
        logger.debug("pageInfo: {}", pageInfo);
        model.addAttribute("list", versionService.listAll().getList());
        return "version/form";
    }

    @RequestMapping("/add/do")
    public String doAdd(RedirectAttributes redirectAttributes,
                        EppdevVersion version, String originVersion){
        try{
            int count = versionService.createNewVersion(version, originVersion);
            if(count == 0){
                redirectAttributes.addFlashAttribute("message", "保存失败：重复？");
                return "redirect:/version/" ;
            } else{
                redirectAttributes.addFlashAttribute("message", "保存成功");
                return "redirect:/version/" + version.getId();
            }

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "保存失败：" + e.getMessage());
            logger.error("Error: {}\n{}", e.getMessage(), e.getStackTrace());
            return "redirect:/version/";
        }
    }

    @RequestMapping("/{id}")
    public String view(Model model,
                       @PathVariable("id") String id){
        model.addAttribute("list", versionService.listTables(id).getList());
        return "table/list";
    }

}
