package study.gradle.taskfilterkotlin

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class HelloServiceTest {

    @Test
    fun greeting() {
        val sut = HelloService()

        val result = sut.greeting()

        Assertions.assertThat(result).isEqualTo("hello")
    }
}