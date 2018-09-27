package domain.offer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class OfferParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "OFFER_PARAMETER_ID",nullable = false)
    private Offer offer;

    public OfferParameter() {
    }
}
