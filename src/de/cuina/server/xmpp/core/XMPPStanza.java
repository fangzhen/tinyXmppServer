package de.cuina.server.xmpp.core;

import java.util.HashMap;

public class XMPPStanza {
	private String name, localName;
	private String value;
	private HashMap<String, String> attributes = new HashMap<String, String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}
}
