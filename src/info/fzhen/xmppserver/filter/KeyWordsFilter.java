package info.fzhen.xmppserver.filter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

import de.cuina.server.xmpp.core.XMPPStanza;

public class KeyWordsFilter implements IFilter{

	public static HashMap<String, String> keywords;
	static {
		keywords = new HashMap<String, String>();
		keywords.put("银行卡", "您的对话涉及财物，谨防上当受骗.");
		keywords.put("sword", "you have sensitive word in your chat");
	}
	public KeyWordsFilter(){
		
	}
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
				Set<String> keySet = keywords.keySet();
				for (String key : keySet){
					if (message.contains(key)){
						message += "\n----" + keywords.get(key)+ "----\n";
						currentStanza.setValue(message);
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
