package domain.category;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Subcategory {
    @Id
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "CATEGORY_ID",nullable = false)
    private Category category;

    public Subcategory() {

    }
}
