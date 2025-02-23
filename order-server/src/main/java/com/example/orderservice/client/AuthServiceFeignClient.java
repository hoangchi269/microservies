package com.example.orderservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "auth-server")
public interface AuthServiceFeignClient {

  @GetMapping(value = "/auth-server/api/hello")
  Object testAPI();

  @GetMapping(value = "/v1/me")
  Object getCurrentUser();

}
