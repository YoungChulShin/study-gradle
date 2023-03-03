# 저장소 설명
gradle 관려 스터디 저장소 

# gradle
## 개념
특징
- opensource [build automation](https://en.wikipedia.org/wiki/Build_automation) tool
- jvm에서 동작한다. 

용어
- Projects: gradle build 대상 프로젝트
   - 빌드 스크립트를 루트 디렉토리에 포함한다. `build.gradle`/`build.gradle.kts` 
- Tasks: 특정 작업을 수행하기 위한 로직을 포함한다. 
  - 컴파일, 테스트, 배포 등
- plugins: 


## Gradle Wrapper
reference
- https://docs.gradle.org/current/userguide/gradle_wrapper.html#gradle_wrapper

개념
- gradle build를 수행하기 위한 추천방법
- gradle version, download url 등을 설정해서 사전에 다운로드한다. 

설정 파일
- gradle/wrapper/gradle-wrapper.properties
- 특정
   - `--distribution-type`: bin 또는 all 사용가능. bin은 runtime만 포함한다. all은 샘플, 문서를 포함한다. 

## CLI
기본 형식
```
gradle [taskNames..] [--option-name...]
```

Task 실행
```
gradle :[taskName] --exampleOption=exampleValue
```

multi project task 실행
```
gradle :[subproject]:[taskName]
```

multi task 실행
- 각 작업의 종속성을 유지하면서 실행된다. 
   ```
   gradle [task1] [task2]
   ```
- 예를 들어서 `gradle clean build`의 경우, build가 clean 보다 먼저 실행되지는 않는다

task 제외
- `-x` 또는 `--exclude-task` 명령어를 이용해서 가능하다
- 의존성이 있는 task는 함께 실행되지 않는다
   - 'gradle dis -x test' 로 수행하면 test와 compileTest task가 수행되지 않는다
      - ![task-graph](https://docs.gradle.org/current/userguide/img/commandLineTutorialTasks.png)

fail이 발생해도 task 수행
- 기본적으로 gradle은 실패하면 바로 멈춘다
- `--continue` 옵션을 이용하면 실패해도 계속 실행한다

### common tasks
tasks
- build: 빌드. 모든 출력을 어셈블링하고 all checks를 수행한다
   ```
   gradle build
   ```
- run: application을 에셈블하고 실행한다
   ```
   gradle run
   ```
- check: verification task를 수행한다. (test, check 등)
   - 임의로 추가한 verification tasks는 안되네
   ```
   gradle check
   ```
- clean:  build 디렉토리 삭제
   ```
   gradle clean
   ```

### Project reporting
tasks
- projects: 프로젝트 리스트 출력
   ```
   gradle projects
   ```
- tasks: task 리스트 출력
   ```
   // group에 속한 task를 출력
   gradle tasks

   // 모든 task 출력
   gradle tasks --all

   // 특정 group의 task 출력
   gradle tasks --group="xxxxx"
   ```
- task 세부 정보 출력
   ```
   gradle -q help --task libs
   ```

옵션 정보들: https://docs.gradle.org/current/userguide/command_line_interface.html#sec:command_line_performance

### Project init
https://docs.gradle.org/current/userguide/command_line_interface.html#sec:command_line_bootstrapping_projects