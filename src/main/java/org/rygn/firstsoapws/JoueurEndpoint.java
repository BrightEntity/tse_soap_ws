package org.rygn.firstsoapws;

import io.spring.guides.gs_producing_web_service.GetJoueurRequest;
import io.spring.guides.gs_producing_web_service.GetJoueurResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class JoueurEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private JoueurRepository joueurRepository;

    @Autowired
    public JoueurEndpoint(JoueurRepository repo) {
        this.joueurRepository = repo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getJoueurRequest")
    @ResponsePayload
    public GetJoueurResponse getJoueur(@RequestPayload GetJoueurRequest request) {
        GetJoueurResponse response = new GetJoueurResponse();

        response.setJoueur(joueurRepository.findJoueur(request.getNom()));

        return response;
    }
}
