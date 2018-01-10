package com.thinkgem.manage.modules.tool.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.manage.common.config.Global;
import com.thinkgem.manage.common.persistence.Page;
import com.thinkgem.manage.common.web.BaseController;
import com.thinkgem.manage.common.utils.StringUtils;
import com.thinkgem.manage.modules.tool.entity.TDictTree;
import com.thinkgem.manage.modules.tool.service.TDictTreeService;

/**
 * 树形数据字典Controller
 * @author gh
 * @version 2018-01-06
 */
@Controller
@RequestMapping(value = "${adminPath}/tool/tDictTree")
public class TDictTreeController extends BaseController {

	@Autowired
	private TDictTreeService tDictTreeService;
	
	@ModelAttribute
	public TDictTree get(@RequestParam(required=false) String id) {
		TDictTree entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tDictTreeService.get(id);
		}
		if (entity == null){
			entity = new TDictTree();
		}
		return entity;
	}
	
	@RequiresPermissions("tool:tDictTree:view")
	@RequestMapping(value = {"list", ""})
	public String list(TDictTree tDictTree, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TDictTree> page = tDictTreeService.findPage(new Page<TDictTree>(request, response), tDictTree); 
		model.addAttribute("page", page);
		return "modules/tool/tDictTreeList";
	}

	@RequiresPermissions("tool:tDictTree:view")
	@RequestMapping(value = "form")
	public String form(TDictTree tDictTree, Model model) {
		model.addAttribute("tDictTree", tDictTree);
		return "modules/tool/tDictTreeForm";
	}

	@RequiresPermissions("tool:tDictTree:edit")
	@RequestMapping(value = "save")
	public String save(TDictTree tDictTree, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tDictTree)){
			return form(tDictTree, model);
		}
		tDictTreeService.save(tDictTree);
		addMessage(redirectAttributes, "保存树形数据字典成功");
		return "redirect:"+Global.getAdminPath()+"/tool/tDictTree/?repage";
	}
	
	@RequiresPermissions("tool:tDictTree:edit")
	@RequestMapping(value = "delete")
	public String delete(TDictTree tDictTree, RedirectAttributes redirectAttributes) {
		tDictTreeService.delete(tDictTree);
		addMessage(redirectAttributes, "删除树形数据字典成功");
		return "redirect:"+Global.getAdminPath()+"/tool/tDictTree/?repage";
	}

}