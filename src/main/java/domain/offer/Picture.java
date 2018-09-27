package domain.offer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "OFFER_ID",nullable = false)
    private Offer offer;

    public Picture() {
    }
}
