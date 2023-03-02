package study.gradle.taskfilterjava;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloServiceIntegrationTest extends IntegrationTest{

  @Autowired
  private HelloService sut;

  @Test
  public void greetingIntegration() {
    var result = sut.greeting();

    Assertions.assertThat(result).isEqualTo("hello");
  }
}
