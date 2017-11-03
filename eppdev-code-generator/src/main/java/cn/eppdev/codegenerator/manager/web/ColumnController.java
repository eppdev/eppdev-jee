/*
 * FileName: ColumnController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-14
 */

package cn.eppdev.codegenerator.manager.web;

import cn.eppdev.codegenerator.manager.entity.EppdevColumn;
import cn.eppdev.codegenerator.manager.service.ConfService;
import cn.eppdev.codegenerator.manager.service.EppdevColumnService;
import cn.eppdev.codegenerator.utils.conf.TypesMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author fan.hao
 */
@Controller
@RequestMapping("/table/{tableId}/column")
public class ColumnController {

    @Autowired
    ConfService confService;

    @Autowired
    EppdevColumnService columnService;

    @RequestMapping("/add/to")
    public String toAdd(Model model,
                        @PathVariable("tableId") String tableId) {
        EppdevColumn column = new EppdevColumn();
        column.setTableId(tableId);
        model.addAttribute("column", column);
        model.addAttribute("typeList", confService.listStdColumnTypes());
        return "column/form";
    }

    @RequestMapping("/add/do")
    public String doAdd(RedirectAttributes redirectAttributes,
                        EppdevColumn eppdevColumn,
                        @PathVariable("tableId") String tableId) {
        try {
            int result = columnService.save(eppdevColumn);
            if (result == 1) {
                redirectAttributes.addFlashAttribute("message", "数据保存成功");
            } else {
                redirectAttributes.addFlashAttribute("message", "保存失败：数据重复？");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "数据保存失败：" + e.getMessage());
        }
        return "redirect:/table/" + tableId;
    }

    @RequestMapping("/update/{columnId}/to")
    public String toUpdate(Model model,
                           @PathVariable("tableId") String tableId,
                           @PathVariable("columnId") String columnId) {
        EppdevColumn column = columnService.get(columnId);
        model.addAttribute("column", column);
        model.addAttribute("typeList", confService.listStdColumnTypes());
        return "column/form";
    }


    @RequestMapping("/update/{columnId}/do")
    public String doUpdate(RedirectAttributes redirectAttributes,
                           EppdevColumn eppdevColumn,
                           @PathVariable("tableId") String tableId) {
        try {
            columnService.save(eppdevColumn);
            redirectAttributes.addFlashAttribute("message", "数据保存成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "数据保存失败：" + e.getMessage());
        }
        return "redirect:/table/" + tableId;
    }

    @RequestMapping("/{columnId}/delete")
    public String doDelete(RedirectAttributes redirectAttributes,
                           @PathVariable("tableId") String  tableId,
                           @PathVariable("columnId") String columnId){
        try {
            columnService.delete(columnId);
            redirectAttributes.addFlashAttribute("message", "数据保存成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "数据保存失败：" + e.getMessage());
        }
        return "redirect:/table/" + tableId;
    }
}
