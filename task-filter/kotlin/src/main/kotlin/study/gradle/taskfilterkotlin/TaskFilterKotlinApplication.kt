package study.gradle.taskfilterkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskFilterKotlinApplication

fun main(args: Array<String>) {
    runApplication<TaskFilterKotlinApplication>(*args)
}
