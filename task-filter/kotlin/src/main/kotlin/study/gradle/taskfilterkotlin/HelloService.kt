package study.gradle.taskfilterkotlin

import org.springframework.stereotype.Service

@Service
class HelloService {

    fun greeting(): String {
        return "hello"
    }
}