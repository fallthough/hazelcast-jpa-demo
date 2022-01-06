package com.demo.hazelcast;

import com.demo.hazelcast.repository.cache.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TestService {

  @Resource
  private TestRepository testRepository;

  public TestDomain query(String name) {
    return testRepository.findByName(name);
  }

  public Iterable<TestDomain> queryAll() {
    return testRepository.findAll();
  }
  public void store(Integer id, String name) {
    TestDomain testDomain = new TestDomain();
    testDomain.setId(id);
    testDomain.setName(name);

    testRepository.save(testDomain);
    log.info("Stored {}", testDomain);
  }

  public void delete() {
    testRepository.deleteAll();
    log.info("Deleted");
  }
}