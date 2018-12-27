package com.vadelic.lexicon.exampleservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by GreenNun on 29/10/2018.
 */
@Entity
@Table(name = "TB_EXAMPLES")
public class ExampleModel extends JPA {
    private String field;

    public ExampleModel(String field) {
        this.field = field;
    }

    @Basic(optional = false)
    @Column(name = "field")
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
