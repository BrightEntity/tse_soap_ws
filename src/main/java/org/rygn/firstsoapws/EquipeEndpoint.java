package org.rygn.firstsoapws;

import io.spring.guides.gs_producing_web_service.GetEquipeRequest;
import io.spring.guides.gs_producing_web_service.GetEquipeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EquipeEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private EquipeRepository equipeRepository;

    @Autowired
    public EquipeEndpoint(EquipeRepository repo) {
        this.equipeRepository = repo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEquipeRequest")
    @ResponsePayload
    public GetEquipeResponse getEquipe(@RequestPayload GetEquipeRequest request) {
        GetEquipeResponse response = new GetEquipeResponse();

        response.setEquipe(equipeRepository.findEquipe(request.getName()));

        return response;
    }
}
