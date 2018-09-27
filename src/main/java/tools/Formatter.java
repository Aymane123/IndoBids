package tools;

import domain.shop.Shop;
import exception.FormatterException;

public interface Formatter {
    /**
     * Convert a String based wire format to a {@link Shop}
     */
    Shop formatToObject(String inputString) throws FormatterException;

}
