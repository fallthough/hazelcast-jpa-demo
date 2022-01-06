package com.demo.hazelcast;

import lombok.Data;
import org.springframework.data.keyvalue.annotation.KeySpace;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@KeySpace("testDomain")
public class TestDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @org.springframework.data.annotation.Id
    private int id;
    private String name;
}
