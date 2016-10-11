package com.nextech.dscrm.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer orderId;
	@Column(name = "clientId")
	private Integer clientId;
	
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "productId")
	private String productId;
	@Column(name = "deliveryDate")
	private Date deliveryDate;
	@Column(name = "status")
	private Integer status;
	@Column(name = "createTime")
	private Date createTime;
	
//	private ClientModel clientModel;
//	private ProductModel productModel;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId")
	public ClientModel getClientModel() {
		return clientModel;
	}
	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}*/
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}*/
	
	
	
	
}
