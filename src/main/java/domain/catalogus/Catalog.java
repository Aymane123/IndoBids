package domain.catalogus;

import domain.shop.Shop;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@Entity
@XmlRootElement(name = "yml_catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp date;
    private Shop shop;

    public Catalog() {
    }

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
