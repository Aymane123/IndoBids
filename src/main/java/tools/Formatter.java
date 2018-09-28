package tools;

import domain.catalogus.Catalog;
import domain.catalogus.CatalogOld;
import domain.shop.Shop;
import exception.FormatterException;

public interface Formatter {
    /**
     * Convert a String based wire format to a {@link Shop}
     */
    Catalog formatToObject(String inputString) throws FormatterException;

}
