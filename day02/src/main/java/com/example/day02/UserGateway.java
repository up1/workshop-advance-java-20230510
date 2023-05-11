package com.example.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${my_url}")
    private String myUrl;

    public UserResponse getUnitById(int userId) {
        String targetUrl = myUrl + "/users/" + userId;
        return restTemplate.getForObject(targetUrl, UserResponse.class);
    }

}
