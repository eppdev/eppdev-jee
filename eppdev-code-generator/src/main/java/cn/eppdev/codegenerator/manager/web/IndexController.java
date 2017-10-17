/*
 * FileName: IndexController.java
 * Author: fan.hao fan.hao@eppdev.cn
 * Date: 2017-10-13
 */

package cn.eppdev.codegenerator.manager.web;

import cn.eppdev.codegenerator.manager.entity.EppdevIndex;
import cn.eppdev.codegenerator.manager.service.EppdevColumnService;
import cn.eppdev.codegenerator.manager.service.EppdevIndexService;
import cn.eppdev.codegenerator.manager.service.EppdevTableService;
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
@RequestMapping("/table/{tableId}/index")
public class IndexController {

    @Autowired
    EppdevIndexService indexService;

    @Autowired
    EppdevTableService tableService;

    @RequestMapping("/add/to")
    public String toAdd(Model model,
                        @PathVariable("tableId") String tableId) {
        EppdevIndex index = new EppdevIndex();
        index.setTableId(tableId);
        model.addAttribute("index", index);
        model.addAttribute("eppdevTable", tableService.get(tableId));
        return "index/form";
    }

    @RequestMapping("/add/do")
    public String doAdd(RedirectAttributes redirectAttributes,
                        @PathVariable("tableId") String tableId,
                        EppdevIndex eppdevIndex) {
        try {
            int count = indexService.save(eppdevIndex);
            if(count == 0){
                redirectAttributes.addFlashAttribute("message", "保存失败：索引重复？");
            }else {

                redirectAttributes.addFlashAttribute("message", "保存成功");
            }

        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "保存失败：" + e.getMessage());
        }
        return "redirect:/table/" + tableId;
    }
}
