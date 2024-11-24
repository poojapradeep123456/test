package com.product.test.model;

import java.time.LocalDate;

public class Sale {

    private int id;
    private int productId;
    private int quantity;
    private LocalDate saleDate;

    private Products product;

    // Constructors
    public Sale() {}

    public Sale(int productId, int quantity, LocalDate saleDate) {
        this.productId = productId;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    // Getters and setters
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getProductId()
    {
        return productId;
    }
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public LocalDate getSaleDate()
    {
        return saleDate;
    }
    public void setSaleDate(LocalDate saleDate)
    {
        this.saleDate = saleDate;
    }
}

