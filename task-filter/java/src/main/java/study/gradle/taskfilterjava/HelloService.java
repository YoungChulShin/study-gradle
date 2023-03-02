package study.gradle.taskfilterjava;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  public String greeting() {
    return "hello";
  }

}