package com.indoleads.tools;

import com.indoleads.domain.catalogus.Catalog;
import com.indoleads.domain.shop.Shop;
import com.indoleads.exception.FormatterException;

public interface Formatter {
    /**
     * Convert a String based wire format to a {@link Shop}
     */
    Catalog formatToObject(String inputString) throws FormatterException;

}
