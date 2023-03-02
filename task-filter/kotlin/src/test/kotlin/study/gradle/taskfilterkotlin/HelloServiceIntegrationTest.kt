package study.gradle.taskfilterkotlin

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloServiceIntegrationTest {

    @Autowired
    private lateinit var sut: HelloService

    @Test
    fun greetingIntegrationTest() {
        val result = sut.greeting()

        Assertions.assertThat(result).isEqualTo("hello")
    }
}