package domain.wrappers;

import domain.category.Category;
import domain.shop.Currency;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class CategoryWrapper {

    private List<Category> categories = null;

    @XmlElement(name = "category")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
