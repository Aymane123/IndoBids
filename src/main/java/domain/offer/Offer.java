package domain.offer;

import domain.category.Category;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Offer {
    @Id
    private int id;

    private String url;
    private double price;
    private double old_price;
    private boolean isDeliverable;
    private String name;
    private String vendor;
    private String model;
    private String description;
    private boolean hasWarranty;
    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Picture> pictures;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "offer")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<OfferParameter> offerParameters;

    public Offer() {

    }
}
