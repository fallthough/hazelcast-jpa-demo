package com.demo.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableHazelcastRepositories(basePackages = {"com.demo.hazelcast.repository.cache"})
@EnableJpaRepositories(basePackages = {"com.demo.hazelcast.repository.dao"})
@Configuration
public class HazelcastConfig{

  @Bean
  public HazelcastInstance hazelcastInstance() {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    return hz;
  }
}
