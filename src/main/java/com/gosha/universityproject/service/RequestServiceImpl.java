package com.gosha.universityproject.service;

import com.gosha.universityproject.util.ModelMapperUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class RequestServiceImpl implements RequestService{

    @Override
    public String getRequest(String request) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080" + request;
        URI uri = new URI(baseUrl);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        String result = ModelMapperUtil.modelMapper().map(response.getBody(), String.class);
        result = result.replace("},{", "\n");
        result = result.replace("[", "");
        result = result.replace("]", "");
        result = result.replace("}", "");
        result = result.replace("{", "");
        result = result.replace("\"", "");
        result = result.replace(":", ": ");
        result = result.replace(",", ", ");
        return result;
    }
}
