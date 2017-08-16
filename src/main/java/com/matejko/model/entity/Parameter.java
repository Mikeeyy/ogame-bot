package com.matejko.model.entity;

import com.matejko.model.common.ParameterName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Mikołaj Matejko on 13.08.2017 as part of ogame-expander
 */
@Entity
public class Parameter extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ParameterName name;

    @Column(nullable = false)
    private String value;

    public Parameter() {
    }

    public Parameter(final ParameterName name, final String value) {
        this.name = name;
        this.value = value;
    }

    public ParameterName getName() {
        return name;
    }

    public void setName(final ParameterName name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
