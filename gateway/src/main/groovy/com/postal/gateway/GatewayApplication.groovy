package com.postal.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class GatewayApplication {

    static void main(String[] args) {
        SpringApplication.run(GatewayApplication, args)
    }

}
