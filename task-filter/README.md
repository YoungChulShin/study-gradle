# 저장소 설명
gradle project에서 테스트 코드를 작성할 때, 특정 Task를 필터링 할 수 있는 방법에 대해서 확인합니다. 

# 참고 링크
Gradle test: https://docs.gradle.org/current/userguide/java_testing.html#sec:configuring_java_integration_tests

baelduing test skip: https://www.baeldung.com/gradle-skip-tests

# Task Filter
## 사용 케이스
다양한 목적으로 사용이 가능하겠지만, 제 경우에는 'unit test'와 'integration test'를 분리하기 위한 목적으로 사용

## 방법 1. 이름 패턴을 이용한 필터링
참고 자료
- reference: https://docs.gradle.org/current/userguide/java_testing.html#test_filtering
- filtering: https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/TestFilter.html

gradle의 `filter` 옵션을 이용하면 특정 패턴의 테스트만 수행되도록 하거나 제외하도록 설정할 수 있다. 
- 방법
   - 'org.gradle.SomeTest', 'org.gradle.SomeTest.someMethod' 같은 fully-qualified 클래스, 메서드 명을 사용
   - '대문자'로 클래스 이름이나 메서드 명을 사용할 수 도 있다. 예: 'SomeTest', 'SomeTest.someMethod'
   - `'*'` 를 이용해서 와일드카드 옵션을 사용할 수도 있다
- 예시
   ```gradle
   test {
    filter {
        //include specific method in any of the tests
        includeTestsMatching "*UiCheck"

        //include all tests from package
        includeTestsMatching "org.gradle.internal.*"

        //include all integration tests
        includeTestsMatching "*IntegTest"
    }
   }
   ```

filter외에 `include`, `exclude` 명령어를 이용해서도 테스트를 추가하거나 제거할 수 있다. 레퍼런스에는 'filter'가 더 선호되는 옵션이라고 되어있다. 


## 방법 2. Junit `Category`, `Tag`를 이용한 필터링
참고 자료
- reference: https://docs.gradle.org/current/userguide/java_testing.html#test_grouping

junit의 `Category`, `Tag` 옵션을 이용하면 테스트를 그룹핑 할 수 있다
- category, tag 정의
   ```java
   @SpringBootTest
   @Tag("IntegrationTest")
   //@Category("IntegrationTest.class")
   public abstract class IntegrationTest { }
   ```
- category 사용
   ```gradle
   test {
        useJUnit {
            includeCategories 'org.gradle.junit.CategoryA'
            excludeCategories 'org.gradle.junit.CategoryB'
        }
   }
   ```
- tag 사용
   ```gradle
   test {
        useJUnitPlatform {
            includeTags 'fast'
            excludeTags 'slow'
        }
    }
   ```