package com.win.dfas.common.enumeration;

public enum FKEnum {

    PUBLISHER("PUBLISHER",new String[]{"PUBLISHER_FK_BOND_PUBLISHER"});
    ;
    private String key;
    private String[] types;

    FKEnum(String key, String[] types) {
        this.key = key;
        this.types = types;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }
}
