package com.indoleads.domain.DTOs;

public class ShopDTO {
    private int id;
    private String name;
    private String url;
    private String local_delivery_cost;

    public ShopDTO() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLocal_delivery_cost() {
        return local_delivery_cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocal_delivery_cost(String local_delivery_cost) {
        this.local_delivery_cost = local_delivery_cost;
    }
}
