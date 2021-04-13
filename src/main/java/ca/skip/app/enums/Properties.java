package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum Properties {
	LANGUAGE(  Property.getProp("./properties/application.properties")),
    CONFIGURATION(Property.getProp("./properties/application.properties"));

    private String descricao;
 
    Properties(String descricao) {
        this.descricao = descricao;
        getDescricao();
    }
 
    public String getDescricao() {
        return descricao;
    }
}
