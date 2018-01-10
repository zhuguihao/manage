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
import com.thinkgem.manage.modules.product.entity.TProductSeries;
import com.thinkgem.manage.modules.product.service.TProductSeriesService;

/**
 * 产品配置-系列Controller
 * @author zgh
 * @version 2018-01-09
 */
@Controller
@RequestMapping(value = "${adminPath}/product/tProductSeries")
public class TProductSeriesController extends BaseController {

	@Autowired
	private TProductSeriesService tProductSeriesService;
	
	@ModelAttribute
	public TProductSeries get(@RequestParam(required=false) String id) {
		TProductSeries entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tProductSeriesService.get(id);
		}
		if (entity == null){
			entity = new TProductSeries();
		}
		return entity;
	}
	
	@RequiresPermissions("product:tProductSeries:view")
	@RequestMapping(value = {"list", ""})
	public String list(TProductSeries tProductSeries, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TProductSeries> page = tProductSeriesService.findPage(new Page<TProductSeries>(request, response), tProductSeries); 
		model.addAttribute("page", page);
		return "modules/product/tProductSeriesList";
	}

	@RequiresPermissions("product:tProductSeries:view")
	@RequestMapping(value = "form")
	public String form(TProductSeries tProductSeries, Model model) {
		model.addAttribute("tProductSeries", tProductSeries);
		return "modules/product/tProductSeriesForm";
	}

	@RequiresPermissions("product:tProductSeries:edit")
	@RequestMapping(value = "save")
	public String save(TProductSeries tProductSeries, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tProductSeries)){
			return form(tProductSeries, model);
		}
		tProductSeriesService.save(tProductSeries);
		addMessage(redirectAttributes, "保存产品配置-系列成功");
		return "redirect:"+Global.getAdminPath()+"/product/tProductSeries/?repage";
	}
	
	@RequiresPermissions("product:tProductSeries:edit")
	@RequestMapping(value = "delete")
	public String delete(TProductSeries tProductSeries, RedirectAttributes redirectAttributes) {
		tProductSeriesService.delete(tProductSeries);
		addMessage(redirectAttributes, "删除产品配置-系列成功");
		return "redirect:"+Global.getAdminPath()+"/product/tProductSeries/?repage";
	}

}