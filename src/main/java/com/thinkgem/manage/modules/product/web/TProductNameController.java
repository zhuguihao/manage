package com.thinkgem.manage.modules.product.web;

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
import com.thinkgem.manage.modules.product.entity.TProductName;
import com.thinkgem.manage.modules.product.service.TProductNameService;

/**
 * 产品配置-产品名称Controller
 * @author zgh
 * @version 2018-01-09
 */
@Controller
@RequestMapping(value = "${adminPath}/product/tProductName")
public class TProductNameController extends BaseController {

	@Autowired
	private TProductNameService tProductNameService;
	
	@ModelAttribute
	public TProductName get(@RequestParam(required=false) String id) {
		TProductName entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tProductNameService.get(id);
		}
		if (entity == null){
			entity = new TProductName();
		}
		return entity;
	}
	
	@RequiresPermissions("product:tProductName:view")
	@RequestMapping(value = {"list", ""})
	public String list(TProductName tProductName, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TProductName> page = tProductNameService.findPage(new Page<TProductName>(request, response), tProductName); 
		model.addAttribute("page", page);
		return "modules/product/tProductNameList";
	}

	@RequiresPermissions("product:tProductName:view")
	@RequestMapping(value = "form")
	public String form(TProductName tProductName, Model model) {
		model.addAttribute("tProductName", tProductName);
		return "modules/product/tProductNameForm";
	}

	@RequiresPermissions("product:tProductName:edit")
	@RequestMapping(value = "save")
	public String save(TProductName tProductName, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tProductName)){
			return form(tProductName, model);
		}
		tProductNameService.save(tProductName);
		addMessage(redirectAttributes, "保存产品配置-产品名称成功");
		return "redirect:"+Global.getAdminPath()+"/product/tProductName/?repage";
	}
	
	@RequiresPermissions("product:tProductName:edit")
	@RequestMapping(value = "delete")
	public String delete(TProductName tProductName, RedirectAttributes redirectAttributes) {
		tProductNameService.delete(tProductName);
		addMessage(redirectAttributes, "删除产品配置-产品名称成功");
		return "redirect:"+Global.getAdminPath()+"/product/tProductName/?repage";
	}

}