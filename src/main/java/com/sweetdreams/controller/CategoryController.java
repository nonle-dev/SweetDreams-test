package com.sweetdreams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sweetdreams.entity.Category;
import com.sweetdreams.models.CategoryModel;
import com.sweetdreams.service.ICategoryService;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	@Autowired
	ICategoryService categoryService;

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "list";
	}
    @GetMapping("add")
	public String Add(ModelMap model) {
		CategoryModel cate = new CategoryModel();
		cate.setIsEdit(false);
		model.addAttribute("category", cate);

		return "addOrEdit";

	}
}