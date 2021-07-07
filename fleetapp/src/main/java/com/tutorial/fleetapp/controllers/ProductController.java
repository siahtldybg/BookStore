package com.tutorial.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tutorial.fleetapp.models.Product;
import com.tutorial.fleetapp.models.ProductType;
import com.tutorial.fleetapp.services.ProductService;
import com.tutorial.fleetapp.services.ProductTypeService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;

	// Get All Countrys
	@GetMapping("/products")
	public String getProduct(Model model) {
		List<Product> productList = productService.getProduct();
		model.addAttribute("products", productList);

		return "/body/product";
	}

	@GetMapping("/productadd")
	public String addProduct(Model model) {
		List<ProductType> productTypeList = productTypeService.getProductType();
		model.addAttribute("producttypes", productTypeList);
		return "/body/productadd";
	}

	@RequestMapping("products/findById")

	@ResponseBody
	public Optional<Product> findById(Integer id) {
		return productService.findById(id);
	}

	// Add Country
	@PostMapping(value = "products/addNew")
	public String addNew(Product product) {
		productService.save(product);
		return "redirect:/products";
	}

	@RequestMapping(value = "products/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Product product) {
		productService.save(product);
		return "redirect:/countries";
	}

	@RequestMapping(value = "products/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		productService.delete(id);
		return "redirect:/countries";
	}

}
