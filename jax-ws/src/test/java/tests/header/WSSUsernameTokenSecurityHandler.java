package tests.header;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPFactory;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;


public class WSSUsernameTokenSecurityHandler implements SOAPHandler<SOAPMessageContext> {

    private String username = "username";
    private String password = "passw0rd";
    
    public WSSUsernameTokenSecurityHandler() {
    }
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty =
                (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (outboundProperty.booleanValue()) {
            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPFactory factory = SOAPFactory.newInstance();
                
                String prefix = "wsse";
                String uri = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
                SOAPElement securityElem =
                        factory.createElement("Security", prefix, uri);
                SOAPElement tokenElem =
                        factory.createElement("UsernameToken", prefix, uri);
                tokenElem.addAttribute(QName.valueOf("wsu:Id"), "UsernameToken-2");
                tokenElem.addAttribute(QName.valueOf("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
                SOAPElement userElem =
                        factory.createElement("Username", prefix, uri);
                userElem.addTextNode(username);
                SOAPElement pwdElem =
                        factory.createElement("Password", prefix, uri);
                pwdElem.addTextNode(password);
                pwdElem.addAttribute(QName.valueOf("Type"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                tokenElem.addChildElement(userElem);
                tokenElem.addChildElement(pwdElem);
                securityElem.addChildElement(tokenElem);
                if (envelope.getHeader() != null) {
                    envelope.getHeader().detachNode();
                 }
                SOAPHeader header = envelope.addHeader();
                header.addChildElement(securityElem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // inbound
        }
        return true;
    }
    @Override
    public Set<QName> getHeaders() {
        return new TreeSet<QName>();
    }
    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }
    @Override
    public void close(MessageContext context) {
    }
}
