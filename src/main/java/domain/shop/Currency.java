package domain.shop;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double rate;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CURRENCY_ID",nullable = false)
    private Shop shop;

    public Currency() {
    }
}
