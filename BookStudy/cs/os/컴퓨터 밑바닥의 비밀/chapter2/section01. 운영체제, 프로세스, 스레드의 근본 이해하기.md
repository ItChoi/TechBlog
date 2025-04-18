# 프로그램이 실행되었지만, 뭐가 뭔지 하나도 모르겠다.

## 2.1 운영 체제, 프로세스, 스레드의 근본 이해하기

### 2.1.1 모든 것은 CPU에서 시작된다.
- CPU에서 시작되는 이유는 간단하다. 모든 것이 단순해 문제 본질을 명확하게 볼 수 있다.
- CPU는 스레드, 프로세스, OS를 알 지 못한다. 단지 두 가지만!
  1. 메모리에서 명령어 1개를 가져 온다.
  2. 명령어 실행 후, 1부터 반복 (1, 2)
  - CPU가 명령어를 가져오는 기준
    - Program Counter (레지스터)
      - 레지스터는 용량은 작고 속도가 매우 빠른 메모리
      - 메모리에 저장된 CPU가 다음에 실행할 명령어 주소 저장
- 실행 명령어 동작 방식
  - 명령어는 메모리에 저장되어 있다 (PC 레지스트리)
  - 메모리 저장 명령어는 디스크에 저장된 실행 파일에서 적재 
  - 실행 파일은 컴파일러로 생성!
  - 컴파일러는 코드 기반으로 기계 명령어 생성
  - 코드 -> 컴파일러 기계 명령어 생성 -> 실행 파일 -> 디스크 -> 메모리(PC) -> CPU
- 프로그래밍은 반드시 시작 지점이 있어야 한다 -> main 함수! (실제 상황은 훨씬 복잡)
  - 프로그램 시작
  - main 함수 대응 첫 기계 명령어 탐색
  - 메모리 주소 PC 레지스터에 기록

### 2.1.2 CPU에서 운영체제까지
- 코드 작성 -> 컴파일러 실행 파일 생성 -> 디스크 적재 -> pc 메모리 저장 -> CPU 명령어 실행 = CPU가 프로그램 실행
  - OS 없이도 CPU에 프로그램 실행 가능 
    - 불가능한 것은 아니지만 과정이 매우 복잡하고 번거롭다.
    - 단점 존재
      - 한 번에 하나의 프로그램만 실행 가능 (음악 들으면서 코드 작성 불가)
      - 직접 사용할 HW와 드라이버 연결
      - print 함수 사용 -> 직접 구현해야 함
      - 모든 것을 직접 해야 한다!
- CPU는 한 번에 한 가지 일만 할 수 있다.
  - 여러 프로그램 중 하나의 프로그램의 기계 명령어만 실행 가능
- 멀티 태스킹
  - 프로그램 일시 중지 후 재시작 (CPU 컨텍스트 스위칭)
    - 일시 중지 -> 상태 유지
    - 상태를 통해 재시작
- OS
  - 프로그램 자동 적재 도구 + 프로세스 관리 도구 -> OS

### 2.1.3 프로세스는 매우 훌륭하지만, 아직 불편하다
- 프로세스의 대략적인 메모리 상태
  - 메모리
    - 스택 영역: 함수의 실행 시간 스택
    - 여유 공간
    - 힙 영역: malloc 함수가 요청을 반환한 메모리가 여기에 할당
    - 데이터 영역: 전역 변수 등 저장
    - 코드 영역: 기계 명령어 저장
- funcA, funcB가 서로 독립저인 함수라고 했을 때 순차적으로 앞 함수가 끝나야 뒤 함수가 실행된다.
  - 3분 -> 4분 = 7분
  - 다중 프로세스 프로그래밍을 통해 ipc -> 프로세스간 통신을 통해 함수 결과 전달
    - 프로세스 생성시 비교적 큰 오버헤드
    - 프로세스별 자체 주소 공간 -> IPC 복잡
  - 스레드를 통해 해결 가능
    - 스레드A, 스레드B -> 주 스레드에서 합친다.

### 2.1.4 프로세스에서 스레드로 진화
- 프로세스 주소 공간
  - CPU가 실행하는 기계 명령어 저장
  - 함수 실행될 때 스택 정보 저장
  - 프로세스 실행시 main 함수 첫 번 째 기계 명령어 주소를 pc 레지스터에 등록
- main 함수와 다른 함수의 차이점
  - 없다. 단지 프로그램 시작시 CPU가 처음으로 실행하는 함수
- 스레드 간에 근본적으로 통신 개념은 존재하지 않는다.
- 스레드를 경량 프로세스라고도 한다.
- 다중 코어 활용을 통해 모든 CPU 최대한 활용 가능!
  - 고성능, 높은 동시성의 기초가 된다.
- 단일 코어에서도 여러 스레드 생성 가능
  - 스레드는 OS 계층에 구현되어 코어 개수와 무관
  - 다중 스레드 -> 공유 리소스 접근시 문제 발생 가능 -> CPU는 스레드를 전혀 고려하지 않고 실행한다.
    - 사용자는 상호 배제, 동기화를 통해 명시적으로 직접 해결 필요!

### 2.1.5 다중 스레드와 메모리 구조

### 2.1.6 스레드 활용 예
- 긴 작업, 짧은 작업 유형
  - 긴 작업
    - 특정 작업 처리 -> 전용 스레드 생성이 가장 적합하고 간단
      - 문서 편집기 -> 디스크 저장 (디스크에 데이터를 쓰는 행위)
  - 짧은 작업
    - 네트워크 요청, 데이터베이스 쿼리 등 처리 시간이 짧은 작업
    - 처리 시간이 짧고, 작업 수가 많다는 특징이 있다.
    - 처리 방법
      - 요청당 스레드: 요청시 작업 처리 스레드 생성, 처리 후 스레드 종료
        - 매번 스레드 생성, 긴 작업에 매우 잘 동작
        - 구현은 간단하지만 단점 존재
          - 스레드 생성과 종료 -> 오버헤드 증가
          - 많은 수 스레드 생성시 메모리 및 시스템 리소스 -> 오버 헤드 증가
          - 스레드 컨텍스트 스위칭 -> 오버헤드 증가
          - 처리 시간 < 리소스 생성 및 삭제 -> 비용이 더 크다, 오버 헤드 증가
      - 스레드 풀

### 2.1.7 스레드 풀의 동작 방식
- 스레드를 미리 생성해두고, 처리 작업 -> 스레드 요청
  - 스레드 생성, 종료 오버헤드가 발생하지 않는다.
  - 스레드 재사용 -> 불필요한 메모리를 소비하지 않는다.
- 스레드 풀은 자료 구조와 대기열 활용 필요
  - 작업 전달 -> 생산자(producer)
  - 스레드 -> 소비자(consumer)
  - 생산자 스레드 -> 작업 대기열 -> 소비자 스레드
    - 스레드 풀의 스레드 -> 작업 대기열에서 블로킹 상태로 대기
    - 작업 대기열은 여러 스레드간 공유 -> 동기화시 상호배제(mutual exclusion) 반드시 처리 필요

### 2.1.8 스레드 풀의 스레드 수
- 스레드 풀의 적절한 스레드 수는 몇 개 일까?
  - 개수 적음 -> CPU 최대 활용 불가
  - 개수 초과 -> 시스템 성능 저하, 메모리 과다 점유, 스레드 컨텍스트 스위칭 오버헤드
  - 먼저 처리 작업 종류를 알아야 한다.
    - 긴 작업 / 짧은 작업 구분 -> 수명 주기 관점 구분
    - CPU 직얍적인 작업 / 입출력 직얍적인 작업 구분 필요 -> 필요한 리소스 관점
      - CPU 직얍적인 작업: 과학 연산, 행렬 연산 등 I/O 의존 없이 처리 가능
        - 스레드 수와 CPU 코어 수 동일 -> CPU 리소스 충분히 활용 가능
      - 입출력 직얍적인 작업: 연산 비중이 낮고, DISK I/O, 네트워크 I/O 등
        - 성능 테스트 도구 필요 -> 입출력 대기 시간(Wait Time)과 CPU 연산 필요 시간(Computing Time)을 평가
        - 일반적으로 I/O 소요 시간 평가는 복잡하고 어렵다.