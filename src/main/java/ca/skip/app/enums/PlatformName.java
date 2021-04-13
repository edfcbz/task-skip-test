package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum PlatformName  {
    ANDROID( Property.getProp("desired.capability.plataformname.android")),
    IOS(     Property.getProp("desired.capability.plataformname.ios")),
    WEB(     Property.getProp("desired.capability.plataformname.web"));
 
    private String descricao;
 
    PlatformName(String descricao) {
        this.descricao = descricao;
        getDescricao();
    }
 
    public String getDescricao() {
        return descricao;
    }

}
