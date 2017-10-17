/*
 * FileName: GeneratorController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-10
 */

package cn.eppdev.codegenerator.manager.web;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.entity.EppdevTable;
import cn.eppdev.codegenerator.manager.service.EppdevIndexService;
import cn.eppdev.codegenerator.manager.service.EppdevTableService;
import cn.eppdev.codegenerator.manager.service.SchemaService;
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

import java.util.Map;

/**
 * @author: fan.hao
 */
@Controller
@RequestMapping("/table")
public class TableController {
    private static Logger logger = LoggerFactory.getLogger(TableController.class);

    @Autowired
    EppdevTableService tableService;

    @Autowired
    SchemaService schemaService;


    @RequestMapping("/test")
    public ModelAndView test(Model model) {
        model.addAttribute("list", schemaService.listTablesFromConn());
        return new ModelAndView("table/list");
    }

    @RequestMapping({"/"})
    public String list(EppdevTable eppdevTable,
                        Model model) {
        PageInfo<EppdevTable> pageInfo = tableService.listLike(eppdevTable);
        model.addAttribute("list", pageInfo.getList());
        return "table/list";
    }

    @RequestMapping("/add/to")
    public String toAdd(Model model) {
        return "table/form";
    }

    @RequestMapping("/add/do")
    public String doAdd(EppdevTable eppdevTable,
                        RedirectAttributes redirectAttributes) {
        String message = null;
        logger.debug("eppdevTable: {}", eppdevTable);
        try {
            int count = tableService.insert(eppdevTable);
            if (count == 0) {
                redirectAttributes.addFlashAttribute("message", "保存失败：重复？");
                return "redirect:/table/";
            } else {
                redirectAttributes.addFlashAttribute("message", "保存成功");
                return "redirect:/table/" + eppdevTable.getId();
            }
        } catch (Exception e) {
            message = "保存失败: " + e.getMessage();
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/table/";
        }
    }

    @RequestMapping("/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        EppdevTable eppdevTable = tableService.get(id);
        model.addAttribute("eppdevTable", eppdevTable);
        return "table/view";
    }

    @RequestMapping("/{id}/update/to")
    public String toUpdate(Model model,
                           @PathVariable("id") String id) {
        EppdevTable eppdevTable = tableService.get(id);
        model.addAttribute("eppdevTable", eppdevTable);
        return "table/form";
    }

    @RequestMapping("/{id}/update/do")
    public String doUpdate(RedirectAttributes redirectAttributes,
                           @PathVariable("id") String id,
                           EppdevTable eppdevTable) {
        try {
            int count = tableService.save(eppdevTable);
            redirectAttributes.addFlashAttribute("message", "保存成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "保存失败：" + e.getMessage());
            logger.error("error: {} \n{}", e.getMessage(), e.getStackTrace());
        }
        return "redirect:/table/" + id;
    }

    @RequestMapping("/{id}/delete")
    public String doDelete() {
        return null;
    }

}
