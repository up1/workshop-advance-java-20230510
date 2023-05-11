package com.example.day02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {

    @Autowired
    private RestTemplate restTemplate;

    public UserResponse getUnitById(int userId) {
        String targetUrl = "https://jsonplaceholder.typicode.com/users/" + userId;
        return restTemplate.getForObject(targetUrl, UserResponse.class);
    }

}
