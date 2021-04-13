package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum AutomatorName  {
    ANDROID( Property.getProp("desired.capability.automator.android")),
    IOS(     Property.getProp("desired.capability.automator.ios")),
    WEB(     Property.getProp("desired.capability.automator.web"));
 
    private String descricao;
 
    AutomatorName(String descricao) {
        this.descricao = descricao;
        getDescricao();
    }
 
    public String getDescricao() {
        return descricao;
    }

}
