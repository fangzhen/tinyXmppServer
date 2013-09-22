package info.fzhen.xmppserver.filter;

import java.util.LinkedList;
import de.cuina.server.xmpp.core.XMPPStanza;

public interface IFilter {
	public boolean startElement(LinkedList<XMPPStanza> stanzaStack);
	public boolean textElement(LinkedList<XMPPStanza> stanzaStack);
	public boolean endElement(LinkedList<XMPPStanza> stanzaStack);
}
