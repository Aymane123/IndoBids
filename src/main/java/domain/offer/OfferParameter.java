package domain.offer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class OfferParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "OFFER_PARAMETER_ID",nullable = false)
    private Offer offer;

    public OfferParameter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
