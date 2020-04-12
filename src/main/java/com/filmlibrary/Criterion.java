package com.filmlibrary;

public class Criterion {

    private String criterion;
    private String value;

    public Criterion(String criterion, String value) {
        this.criterion = criterion;
        this.value = value;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
