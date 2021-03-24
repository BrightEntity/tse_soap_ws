package org.rygn.firstsoapws;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

@SpringBootTest
public class EquipeEndpointTest  {
    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockWebServiceClient;

    @BeforeEach
    public void createClient() throws Exception {
        mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    public void equipeEndpoint() {
        Source requestPayload = new StringSource("<getEquipeRequest xmlns='http://spring.io/guides/gs-producing-web-service'>" +
                "<equipe>PSG</equipe></getEquipeRequest>");

        Source expectedResponsePayload = new StringSource("" +
                "<getEquipeResponse xmlns='http://spring.io/guides/gs-producing-web-service'>" +
                "<equipe>" +
                "   <name>PSG</name>" +
                "   <joueurs>" +
                "       <joueur>" +
                "           <prenom>Neymar</prenom>" +
            "               <nom>da Silva Santos Junior</nom>" +
                "       </joueur>" +
                "   </joueurs>" +
                "</equipe>" +
                "</getEquipeResponse>"
        );

        mockWebServiceClient.sendRequest(withPayload(requestPayload))
                .andExpect(payload(expectedResponsePayload));
    }
}
