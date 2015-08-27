package com.shopme.db.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_notification")
public class ProductNotification {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "productId")
	private Integer productId;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "qty_requested")
	private Integer quantityRequested;
	@Column(name = "status")
	private String status;
	@Column(name = "date_noticed")
	private Date dateNoticed;

	public ProductNotification() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(Integer quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateNoticed() {
		return dateNoticed;
	}

	public void setDateNoticed(Date dateNoticed) {
		this.dateNoticed = dateNoticed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateNoticed == null) ? 0 : dateNoticed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime
				* result
				+ ((quantityRequested == null) ? 0 : quantityRequested
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductNotification other = (ProductNotification) obj;
		if (dateNoticed == null) {
			if (other.dateNoticed != null)
				return false;
		} else if (!dateNoticed.equals(other.dateNoticed))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantityRequested == null) {
			if (other.quantityRequested != null)
				return false;
		} else if (!quantityRequested.equals(other.quantityRequested))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductNotification [id=" + id + ", productId=" + productId
				+ ", userEmail=" + userEmail + ", quantityRequested="
				+ quantityRequested + ", status=" + status + ", dateNoticed="
				+ dateNoticed + "]";
	}

}
