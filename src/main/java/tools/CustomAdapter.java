package tools;

import domain.shop.Shop;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomAdapter extends XmlAdapter {
    @Override
    public Shop unmarshal(Object v) throws Exception {
        return null;
    }

    @Override
    public Shop marshal(Object v) throws Exception {
        return null;
    }
}
