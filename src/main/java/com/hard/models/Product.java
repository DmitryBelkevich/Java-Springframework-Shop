package com.hard.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Model {
	private static final long serialVersionUID = -1389912391391510362L;
	
	@Column(name = "title", length = 50)
	private String title;
	
	@Column(name = "description", length = 1024)
	private String description;
	
	@Column(name = "count")
	private int count;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;
	
	public Product() {
		super();
	}
	
	public Product(long id) {
		super(id);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	
	@Override
	public String toString() {
		return "Product["
				+ "id=" + id
				+ ", title=" + title
				+ ", description=" + description
				+ ", count=" + count
				+ ", price=" + price
				//+ ", productCategory=" + productCategory
				+ "]";
	}
}