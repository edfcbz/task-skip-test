package ca.skip.app.enums;

import ca.skip.utils.Property;

public enum PlatformVersion  {
    ANDROID( Property.getProp("desired.capability.plataformname.android")),
    IOS(     Property.getProp("desired.capability.plataformname.name.ios")),
    WEB(     Property.getProp("desired.capability.plataformname.name.web"));
 
    private String descricao;
 
	PlatformVersion(String descricao) {
		this.descricao = descricao;
		getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

}
