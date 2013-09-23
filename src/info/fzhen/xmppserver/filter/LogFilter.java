package info.fzhen.xmppserver.filter;

import java.util.LinkedList;
import java.util.Set;

import de.cuina.server.xmpp.core.XMPPStanza;

public class LogFilter implements IFilter{
	private static Set<String> keywords;

	@Override
	public boolean startElement(LinkedList<XMPPStanza> stanzaStack) {
		return false;
	}

	@Override
	public boolean textElement(LinkedList<XMPPStanza> stanzaStack) {
		if (stanzaStack == null)
			return false;
		XMPPStanza currentStanza = stanzaStack.peek();
		if (currentStanza == null)
			return false;
		if (currentStanza.getName().equals("{jabber:client}body")) {
			if (stanzaStack.get(1).getName().equals("{jabber:client}message")) {
				String message = currentStanza.getValue();
				for (String key : keywords){
					if (message.contains(key)){
						//LOG
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean endElement(LinkedList<XMPPStanza> stanzaStack) {
		return false;
	}

}
