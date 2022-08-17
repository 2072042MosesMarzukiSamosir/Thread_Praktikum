package com.example.database_connectivity.model_entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "databaseconnection_pt", catalog = "")
public class CategoryEntity {
    @Override
    public String toString() {
        return nama;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategory")
    private int idCategory;
    @Basic
    @Column(name = "nama")
    private String nama;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return idCategory == that.idCategory && Objects.equals(nama, that.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, nama);
    }
}
