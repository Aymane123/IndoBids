package domain.shop;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @XmlElement(name="id")
    private String currencyId;
    @XmlElement(name="rate")
    private double rate;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CURRENCY_ID",nullable = false)
    private Shop shop;

    public Currency() {
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
