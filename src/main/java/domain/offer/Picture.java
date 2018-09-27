package domain.offer;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

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

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
