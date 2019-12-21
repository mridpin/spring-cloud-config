package com.ridao.microservices.limitsservice.domain;

import java.util.Objects;

public class LimitsConfiguration {

    private Integer minimum;
    private Integer maximum;

    public LimitsConfiguration() {
        super();
    }

    public LimitsConfiguration(Integer minimum, Integer maximum) {
        super();
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "LimitsConfiguration{" +
                "min=" + minimum +
                ", max=" + maximum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LimitsConfiguration that = (LimitsConfiguration) o;
        return Objects.equals(minimum, that.minimum) &&
                Objects.equals(maximum, that.maximum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimum, maximum);
    }
}
