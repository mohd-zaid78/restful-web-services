package com.zaid.basepackage.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zaid.basepackage.request.Product;

@Component
public class ProductResponse {
	private Boolean error;
	private String msg;
	private List<Product> products;
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
