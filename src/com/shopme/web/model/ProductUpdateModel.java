package com.shopme.web.model;

public class ProductUpdateModel {
	private Integer productId;
	private String productName;
	private Integer newQuantity;
	private Double newPrice;

	public ProductUpdateModel() {
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(Integer newQuantity) {
		this.newQuantity = newQuantity;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((newPrice == null) ? 0 : newPrice.hashCode());
		result = prime * result
				+ ((newQuantity == null) ? 0 : newQuantity.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
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
		ProductUpdateModel other = (ProductUpdateModel) obj;
		if (newPrice == null) {
			if (other.newPrice != null)
				return false;
		} else if (!newPrice.equals(other.newPrice))
			return false;
		if (newQuantity == null) {
			if (other.newQuantity != null)
				return false;
		} else if (!newQuantity.equals(other.newQuantity))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductUpdateModel [productId=" + productId + ", productName="
				+ productName + ", newQuantity=" + newQuantity + ", newPrice="
				+ newPrice + "]";
	}

}
