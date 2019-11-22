package com.swagger.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about the Book. ")
public class Book {
	@Id
	@GeneratedValue
    @ApiModelProperty(notes = "The database generated bookId",readOnly = true)
	private Integer bookId;
	
    @ApiModelProperty(notes = "Book name")
	private String name;
	
    @ApiModelProperty(notes = "Book price")
	private double price;
    
    @ApiModelProperty(notes = "Book creation time" ,readOnly = true)
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Date createdAt;

    @ApiModelProperty(notes = "Book updation time",readOnly = true)
	@UpdateTimestamp
	private Date updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getBookId() {
		return bookId;
	}
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
