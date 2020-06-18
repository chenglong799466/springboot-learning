package com.chenglong.study.model;


public enum UserSex {
    MALE("MALE"),
    FEMALE("FEMALE");

    private String text;

    UserSex(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }

}
