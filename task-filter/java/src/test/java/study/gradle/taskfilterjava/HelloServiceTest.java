package study.gradle.taskfilterjava;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void greeting() {
    var sut = new HelloService();
    var result = sut.greeting();

    Assertions.assertThat(result).isEqualTo("hello");
  }
}