package com.hard.models;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_order")
public class ProductOrder extends Model {
	private static final long serialVersionUID = 8732154330942840609L;
	
	@Column(name = "date")
	private GregorianCalendar date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	public ProductOrder() {
		super();
	}
	
	public ProductOrder(long id) {
		super(id);
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	public GregorianCalendar getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "ProductCategory["
				+ "id=" + id
				+ ", date=" + date
				+ ", user=" + user
				+ ", product=" + product
				+ "]";
	}
}