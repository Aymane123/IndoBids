package domain.wrappers;

import domain.offer.Offer;
import domain.shop.Currency;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class OfferWrapper {

    private List<Offer> offers = null;

    @XmlElement(name = "offer")
    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

}
