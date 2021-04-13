package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum Language {
	FRENCH(Property.getProp("language.french.text.definition")),
    ENGLISH(Property.getProp("language.english.text.definition")),	
	ITALIAN(Property.getProp("language.italian.text.definition")),
	SPANISH(Property.getProp("language.spanish.text.definition")),
	GERMAN(Property.getProp("language.german.text.definition")),
	PORTUGUESE(Property.getProp("language.portuguese.text.definition"));
	
    private String descricao;
 
    Language(String descricao) {
        this.descricao = descricao;
        getDescricao();
    }
 
    public String getDescricao() {
        return descricao;
    }
}
