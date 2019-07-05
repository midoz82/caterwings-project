package com.caterwings.project.models;



import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "Product")
public class Product {
    @Column(name = "vendorUID")
    String vendorUID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "image")
    private Blob image;

    //String Dietary flags: vegan, lactose-free, and more flags to come;
    @Column(name = "numberofviews")
    private int numberOfViews;

    public String getVendorUID() {
        return vendorUID;
    }

    public void setVendorUID(String vendorUID) {
        this.vendorUID = vendorUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }
}
