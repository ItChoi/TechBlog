# 프로그램이 실행되었지만, 뭐가 뭔지 하나도 모르겠다.
- 콜백 개념이 왜 필요할까?

### 2.5.1 모든 것은 다음 요구에서 시작된다.

### 2.5.2 콜백이 필요한 이유
- 함수를 변수처럼 사용 가능
  - void makeDonut(func f) { f(); }
    - 각 요구사항에 맞는 함수를 매개변수로 받아 사용 -> 콜백 함수
    - 일반적으로 콜백 함수는 직접 구현한다.
    - 콜백 함수를 호출하는 것은 다른 모듈이나 스레드

### 2.5.3 비동기 콜백
- 주 스레드에서 새로운 스레드를 생성하고, 즉시 반환해 주 스레드의 로직을 빠르게 처리 할 수 있다.
  - 주 스레드 로직이 완료돼도 새 스레드 로직이 종료되지 않았을 수도 있으니 주의

### 2.5.4 비동기 콜백은 새로운 프로그래밍 사고방식으로 이어진다.
- 함수 호출시 익숙한 사고방식
  - 동기 호출
    1. 함수 호출, 결과 획득
    2. 획득 결과 처리
- 비동기 콜백
  - 호출된 함수는 즉시 반환

### 2.5.5 콜백 함수의 정의
- 콜백 함수: 매개 변수로 전달되는 실행 가능한 코드
  - 실행 가능한 코드인 함수
- 콜백 함수 호출 시점
  - 이벤트 발생 -> 처리 코드 호출 필요 -> 콜백 함수 유용!

#### 2.5.6 두 가지 콜백 유형
- 동기 콜백
  - 가장 익숙한 콜백 유형
  - 블로킹 콜백이라고도 한다.
- 비동기 콜백
  - 다중 코어 리소스 활용이 상대적으로 더 좋다.
  - 입출력 작업에 자주 사용
  - 동시성이 높은 시나리오에 적합

### 2.5.7 비동기 콜백의 문제: 콜백 지옥
- 실무는 복잡하고 호출 개수가 너무 많다.
  - 콜백 지옥 빠질 가능성이 높다.