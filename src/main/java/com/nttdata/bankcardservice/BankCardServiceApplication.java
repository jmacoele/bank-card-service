package com.nttdata.bankcardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * Bank Credit Service Application.
 *
 * @author jmacoele
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
public class BankCardServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankCardServiceApplication.class, args);
  }

}
