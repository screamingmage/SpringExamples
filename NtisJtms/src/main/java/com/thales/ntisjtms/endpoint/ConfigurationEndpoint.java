package com.thales.ntisjtms.endpoint;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ConfigurationEndpoint {
	
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationEndpoint.class);
	
	private static final String NAMESPACE_URI = "http://www.thalesgroup.com/NTIS/Datex2Extensions/1.0Beta1";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "AnprConfigurationRequest")
	public @ResponsePayload Element handleConfigurationRequest(@RequestPayload Element configurationRequest) {
		LOG.info("Message received: " + configurationRequest.asXML());
		return createAnprConfigurationResponse();
	}
	
	public Element createAnprConfigurationResponse() {
		Document document = DocumentHelper.createDocument();
        Element response = document.addElement("AnprConfigurationResponse", NAMESPACE_URI);
        response.addElement("message").addText( "OK" );
        return document.getRootElement();
	}
	
}
