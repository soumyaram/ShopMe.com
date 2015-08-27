package com.shopme.web.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductServiceModel {
	@XmlElement
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private String imageUrl;
	@XmlElement
	private String price;
	@XmlElement
	private Integer reorderLevel;
	@XmlElement
	private String color;
	@XmlElement
	private String country;
	@XmlElement
	private Integer qtyAvailable;

	public ProductServiceModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(Integer qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((qtyAvailable == null) ? 0 : qtyAvailable.hashCode());
		result = prime * result
				+ ((reorderLevel == null) ? 0 : reorderLevel.hashCode());
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
		ProductServiceModel other = (ProductServiceModel) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qtyAvailable == null) {
			if (other.qtyAvailable != null)
				return false;
		} else if (!qtyAvailable.equals(other.qtyAvailable))
			return false;
		if (reorderLevel == null) {
			if (other.reorderLevel != null)
				return false;
		} else if (!reorderLevel.equals(other.reorderLevel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductServiceModel [id=" + id + ", name=" + name
				+ ", imageUrl=" + imageUrl + ", price=" + price
				+ ", reorderLevel=" + reorderLevel + ", color=" + color
				+ ", country=" + country + ", qtyAvailable=" + qtyAvailable
				+ "]";
	}

}
