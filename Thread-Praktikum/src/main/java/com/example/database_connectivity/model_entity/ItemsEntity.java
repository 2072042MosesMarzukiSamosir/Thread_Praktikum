package com.example.database_connectivity.model_entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items", schema = "databaseconnection_pt", catalog = "")
public class ItemsEntity {

    @Override
    public String toString() {
        return idItems + name + price + categoryByCategoryIdCategory;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idItems")
    private int idItems;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Double price;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "Category_idCategory", referencedColumnName = "idCategory", nullable = false)
    private CategoryEntity categoryByCategoryIdCategory;

    public int getIdItems() {
        return idItems;
    }

    public void setIdItems(int idItems) {
        this.idItems = idItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsEntity that = (ItemsEntity) o;
        return idItems == that.idItems && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idItems, name, price, description);
    }

    public CategoryEntity getCategoryByCategoryIdCategory() {
        return categoryByCategoryIdCategory;
    }

    public void setCategoryByCategoryIdCategory(CategoryEntity categoryByCategoryIdCategory) {
        this.categoryByCategoryIdCategory = categoryByCategoryIdCategory;
    }
}
