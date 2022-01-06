package com.demo.hazelcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import static java.lang.System.nanoTime;

@RestController
@RequestMapping("/")
public class TestController {

  @Autowired
  private TestService testService;

  @GetMapping("query")
  public String query(@RequestParam(value = "name") String input) {
    long start1 = nanoTime();
    String result = testService.query(input).toString();
    long end1 = nanoTime();
    return result + ". Took " + TimeUnit.NANOSECONDS.toMillis(end1 - start1) + "ms";
  }

  @GetMapping("store")
  public void store(@RequestParam(value = "id") Integer id, @RequestParam(value = "name") String name) {
    testService.store(id, name);
  }

  @GetMapping("delete")
  public void delete() {
    testService.delete();
  }


  @GetMapping("query-all")
  public String queryAll() {
    long start1 = nanoTime();
    String result = testService.queryAll().toString();
    long end1 = nanoTime();
    return result + ". Took " + TimeUnit.NANOSECONDS.toMillis(end1 - start1) + "ms";
  }



}