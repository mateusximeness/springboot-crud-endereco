package com.springboot.endereco.repository;

import com.springboot.endereco.dto.representation.CoordenadasResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class GeoCodingRepository {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${geoapi.url}")
    private String googleApiUrl;
    @Value("${geoapi.key}")
    private String key;

    public CoordenadasResponse buscar(String endereco) {
        var uri = montaUri(endereco);
        var response
                = restTemplate.getForEntity(uri.toUriString()
                , CoordenadasResponse.class);
        return response.getBody();
    }

    public UriComponents montaUri(String endereco) {
        return UriComponentsBuilder.newInstance()
                .scheme("https").host(googleApiUrl)
                .path("/maps/api/geocode/json")
                .queryParam("address", endereco)
                .queryParam("key", key)
                .build();
    }
}
