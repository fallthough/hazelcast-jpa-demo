package com.demo.hazelcast.repository.cache;

import com.demo.hazelcast.TestDomain;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

public interface TestRepository extends HazelcastRepository<TestDomain, String> {
    TestDomain findByName(String name);
}
