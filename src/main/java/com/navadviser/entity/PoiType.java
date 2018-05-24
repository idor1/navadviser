package com.navadviser.entity;

public enum PoiType {
    MARINA("MARINA"), BOUY("BOUY"), ANCORAGE("ANCORAGE"), NATURE_ATTRACTION("NATURE_ATTRACTION");

    private String desc;

    PoiType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
