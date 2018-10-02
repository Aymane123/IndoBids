package com.indoleads.domain.category;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;


public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Category category;

    public Subcategory() {

    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
