package com.indoleads.domain.wrappers;

import com.indoleads.domain.shop.Currency;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CurrencyWrapper {

    private List<Currency> currencies = null;

    @XmlElement(name = "currency")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

}
