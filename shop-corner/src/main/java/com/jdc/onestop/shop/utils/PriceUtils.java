package com.jdc.onestop.shop.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.jdc.onestop.shop.entity.Price;

public class PriceUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	public Price getCurrentPrice(List<Price> prices) {
		return prices.stream().filter(a -> a.getRefDate().compareTo(new Date()) <= 0)
				.sorted((b,c) -> c.getRefDate().compareTo(b.getRefDate()))
				.findFirst().orElse(null);
	}
}
