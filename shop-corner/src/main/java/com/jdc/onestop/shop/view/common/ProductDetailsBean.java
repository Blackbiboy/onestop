package com.jdc.onestop.shop.view.common;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.onestop.shop.entity.OrderDetails;
import com.jdc.onestop.shop.entity.Price;
import com.jdc.onestop.shop.entity.Product;
import com.jdc.onestop.shop.entity.Product.Size;
import com.jdc.onestop.shop.service.ProductService;
import com.jdc.onestop.shop.utils.ParamsHelper;
import com.jdc.onestop.shop.utils.PriceUtils;
import com.jdc.onestop.shop.view.member.MyCartBean;

@Named
@ViewScoped
public class ProductDetailsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;

	@Inject
	private ProductService service;
	
	@Inject
	private MyCartBean cart;
	
	@Inject
	private PriceUtils priceUtils;
	
	private Size size;
	private int count;

	@PostConstruct
	private void init() {
		String stId = ParamsHelper.getParam("id");
		if (null != stId) {
			product = service.findProductById(Integer.parseInt(stId));
		}
	}
	
	public String addToCart() {
		
		OrderDetails order = new OrderDetails();
		order.setProduct(product);
		order.setCount(count);
		order.setSize(size);
		Price currentPrice = priceUtils.getCurrentPrice(product.getPrices());
		order.setUnitPrice(currentPrice.getPrice());
		order.setSubTotal(count * order.getUnitPrice());
		cart.addToCart(order);
		
		return "/public/products?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
