# 자바 8, 9, 10, 11: 무슨 일이 일어나고 있는가?
챕터 내용
1. 자바가 거듭 변화하는 이유
2. 컴퓨팅 환경의 변화
3. 자바에서 부여되는 시대적 변화 요구
4. 자바 8과 9의 새로운 핵심 기능 소개
---

1996년 첫 JDK(Java Development Kit) 1.0이 발표됐다.
JDK는 꾸준히 발전해왔다.
- 1995년 베타 버전 공개
- 자바1.1 (1997)
- 자바7 (2011)
- 자바10 (2018)
- 자바11 (2018)

이런 변화를 눈여겨봐야 하는 이유가 뭘까?
(?) 짧은 기간에 많이 사용했고, 많이 사용할 수 밖에 없는 이유가 있었나?

## 1.1 역사의 흐름은 무엇인가?
- 자바8: 획기적이고 생산성 면에서 가장 큰 변화가 있었다.
- 자바9: 중요한 변화가 있었긴 하다.
- 자바10: 형 추론 관련 약간의 변화 정도

이러한 변화들 덕분에 프로그램을 더 쉽게 구현하고, 생산성이 좋아졌다.
(?) 그래서 변화의 이유가 무엇일까, 단순히 더 많은 개발자가 쉽게 접근하고 생산성을 좋게 만들기 위함인가? 조금 더 구체적인 근거는 없으려나
(?:!) 단순히 SW의 변화나 대중들의 선호도 뿐만 아니라 HW 변화도 영향을 미친 것 같다.

**사과 목록 무게순 정렬 코드 예시**
(!) 보통 필요할 때 구글링을 통해 알게되어 jdk 변화로 인한 가독성은 인지하지 못했고, 
당연하게만 사용하던 코드들이 jdk 버전간 비교를 통해 보니, 확실히 자바 버전이 올라가면서 가독성이 좋아진 것 같다.

멀티코어 CPU 대중화와 같은 하드웨어적인 변화도 자바 8에 영향을 미쳤다.
--- 
**듀얼 혹은 쿼드 코어 이상 지원 CPU 내장**
- 기존, 대부분 자바 프로그램은 코어 중 하나만 사용
  - 나머지 코어는 유휴idle 상태 또는 타 프로그램과 프로세스 파워를 나눠 사용

자바 8 등장 전, 나머지 코어 활용을 위해 스레드를 사용하기도 했다.
이는 관리가 어렵고, 많은 문제가 발생 할 수 있다.
(?) 공유 자원 관리, 레이드 컨디션?
--- 

자바 5에서는 스레드 풀, 병렬 실행 컬렉션 등 강력한 도구 도입
자바 7에서 병렬 실행에 도움을 주는 포크/조인 프레임워크를 제공 그러나 활용이 쉽지 않았다.

자바8은 간결한 코드, 멀티 코어 프로세서의 쉬운 활용 두 가지 요구사항을 기반으로 한다.
자바 8의 새로운 기법은 몇 가지 규칙을 지켜야 한다.
새로운 기법 부터 살펴보자.
1. 스트림 API
2. 메서드에 코드를 전달하는 기법
3. 인터페이스의 디폴트 메서드

- 스트림 API
   - 디비 질의 처리하는 것 처럼 병렬 연산을 지원한다.
   - 멀티코어 CPU 이용보다 비용이 비싼 키워드 synchronized를 사용하지 않아도 된다.
     (?) 정확히 어떤 상황을 말하는지 모르겠다.
   - 스트림 API 덕분에 새로운 기법 2, 3이 존재할 수 있다.

- 메서드에 코드를 전달하는 기법
  - 새롭고 간결한 방식으로 동작 파라미터 구현 가능
    - 예시
      - 약간 다른 두 개의 메서드 존재
      - 인수를 이용해 다른 동작하도록 메서드 통합이 바람직한 상황
        (?) 무슨말인지 모르겠다. 결론적으로 코드가 짧아지고, 불필요한 에러도 줄일 수 있다.
  - 함수형 프로그래밍에서 위력 발휘
- 인터페이스의 디폴트 메서드

(!) 1.1은 대략적으로 자바의 흐름을 큰 틀에서 얘기한 것 같다. 

## 1.2 왜 아직도 자바는 변화하는가?
1960년대 사람들은 완벽한 프로그래밍 언어를 찾고자 노력했다.
다양한 언어가 나왔고, 나올 것인지 예측하며 이러한 결론에 도달했다.
"프로그래밍 언어가 마치 생태계와 닮았다"

완벽한 언어는 현실적으로 존재하지 않았다.
생태계를 모두 표현할 언어는 없으며, 각 각의 장단점을 갖고 있었다.

특정 분야의 장점을 가진 언어는 다른 경쟁 언어를 도태시킨다.
프로그래밍에서 언어를 바꾼다는 것은 쉽지 않지만, 개발자들에게 자연스러운 현상이 된다.

자바는 1995년 첫 베타 버전 공개 이후로 경쟁 언어를 대신하여 성공적으로 사용되어 왔다.

### 1.2.1 프로그래밍 언어 생태계에서 자바의 위치
- 자바는 출발이 좋았다.
  - 많은 유용한 라이브러리 포함
  - 잘 설계뙨 객체지향 언어
  - 스레드와 락을 이용한 동시성 지원

코드를 JVM 바이트 코드로 컴파일하는 특징을 갖고 있다.
JVM의 업데이트를 통해 경쟁 언어와 상호 동작 가능되도록 하고, 다양한 임베디드 컴퓨팅 분야를 장악했다.

**자바는 어떻게 대중적인 프로그래밍 언어로 성장했는가?**
객체지향은 1990년대 두 가지 이유로 각광받았다.
1. 캡슐화
2. 객체지향의 정신적인 모델(?)
   - 모든 것은 객체다.
   - 일단 만들면 모든 곳에서 실행 가능 (write-once run-anywhere)

하드웨어의 발전으로 프로그래머의 시간이 더욱 중요한 요소로 부각
(!) 자바 언어가 프로그래머의 시간을 상대적으로 줄여줄 수 있었던 것 같다. (생산성, 안정성)
---

프로그래밍 언어의 생태계 변화
- 빅데이터

멀티코어 컴퓨터, 컴퓨팅 클러스터를 이용해 빅데이터의 효과적 처리 필요성이 커졌다.
즉 병렬 프로세싱 활용이 필요해졌지만 자바로 충분한 대응을 하지 못한다.

생태계를 요약하자면, 새로운 언어가 등장하고 변화하고 빠르게 적응해가면서 점점 대중화된다.

(!) 자바의 유용한 라이브러리, 잘 설계된 객체지향, 스레드와 락을 이용한 동시성 지원 등 
많은 장점과 지속적인 업데이트를 통해 생태계의 빠르게 적응해가며, 대중화된 것 중 하나가 자바란 것 같다.

### 1.2.2 스트림 처리
스트림이란 한 번에 한 개씩 만들어지는 연속적인 데이터 항목들의 모임이다.







## 1.3 자바 함수

## 1.4 스트림

## 1.5 디폴트 메서드와 자바 모듈











