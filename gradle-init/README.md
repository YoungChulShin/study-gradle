# 저장소 설명
gradle 을 이용해서 프로젝트를 생성하는 방법을 알아봅니다. 

# 프로젝트 생성 방법
reference: https://docs.gradle.org/current/samples/sample_building_java_applications.html

## gradle init 명령어를 이용한 프로젝트 생성
명령어 
```
gradle init
```

옵션 정보
- https://docs.gradle.org/current/samples/sample_building_java_applications.html#run_the_init_task 참고

## build.gradle 정보
```gradle
// cli application 빌드를 위해서 application 플러그인 적용
plugins {
    id 'application' 
}

repositories {
    mavenCentral() 
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1' 

    implementation 'com.google.guava:guava:31.1-jre' 
}

// define main class
application {
    mainClass = 'demo.App' 
}

tasks.named('test') {
    useJUnitPlatform() 
}
```