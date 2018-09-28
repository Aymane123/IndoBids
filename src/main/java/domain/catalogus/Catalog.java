package domain.catalogus;

import domain.shop.Shop;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Catalog of the {@Shop} provided by the client
 */
@XmlRootElement(name = "yml_catalog")
public class Catalog {
    private Shop shop;

    public Catalog() {

    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
