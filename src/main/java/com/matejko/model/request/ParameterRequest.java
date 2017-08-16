package com.matejko.model.request;

import com.matejko.model.common.ParameterName;

/**
 * Created by Mikołaj Matejko on 13.08.2017 as part of ogame-expander
 */
public class ParameterRequest {
    private ParameterName name;
    private String value;

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
