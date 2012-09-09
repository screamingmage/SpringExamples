package com.thales.ntisjtms.service;

import java.io.InputStream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class PublishingService {
	
	private static final String NTIS_JTMS_URL = "http://localhost:8880/NtisJtms/ntisjtms/";
	
	private final WebServiceTemplate webServiceTemplate;
	
	public PublishingService() {
		webServiceTemplate = new WebServiceTemplate();
	}
	
	public boolean sendConfigurationData(String url) {
		InputStream configurationData = this.getClass().getClassLoader().getResourceAsStream("configuration_data.xml");
		Assert.notNull(configurationData);
		
		StreamSource source = new StreamSource(configurationData);
        StreamResult result = new StreamResult(System.out);
        
        return webServiceTemplate.sendSourceAndReceiveToResult(NTIS_JTMS_URL, source, result);
	}
	
}
