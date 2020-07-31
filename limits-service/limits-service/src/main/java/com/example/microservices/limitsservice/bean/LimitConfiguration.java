package com.example.microservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class LimitConfiguration {
    int maximum;
    int minimum;

    public LimitConfiguration() {
    }

    public LimitConfiguration(int i, int i1) {
        this.maximum = i;
        this.minimum = i1;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }


    @Override
    public String toString() {
        return "LimitConfiguration{" +
                "maximum=" + maximum +
                ", minimum=" + minimum +
                '}';
    }
}
