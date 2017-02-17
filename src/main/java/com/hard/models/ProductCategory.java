package com.hard.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory extends Model {
	private static final long serialVersionUID = -1069415488948343467L;
	
	@Column(name = "title", length = 255)
	private String title;
	
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<>();
	
	public ProductCategory() {
		super();
	}
	
	public ProductCategory(long id) {
		super(id);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	
	@Override
	public String toString() {
		return "ProductCategory["
				+ "id=" + id
				+ ", title=" + title
				//+ ", products=" + products
				+ "]";
	}
}