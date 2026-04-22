# WebFlux
- Spring reactive-stack 웹 프레임워크
- non-blocking I/O
- Reactive Streams 기반의 비동기 프로그래밍 모델
- Netty, Servlet 컨테이너 위에서 동작 가능
- 적은 스레드 수로 많은 동시 I/O 요청 처리 -> 요청 처리 과정을 non-blocking 흐름으로 구성
- I/O bound workload에서 스레드를 오래 점유하지 않도록 한다.

## MVC와 차이점
- 요청 처리 모델이 다르다.
  - MVC
    - 요청 1개는 스레드 한개 점유 -> blocking 모델
    - ex) 손님 1명당 직원 1명이 끝까지 붙는다.
  - WebFlux
    - 요청 자체가 non-blocking
    - 직원이 주문만 받고, 기다리는 동안 다른 손님 주문도 받는다.

## Mono / Flux 
- Mono
  - 0개 또는 1개
- Flux
  - 0개 이상

## WebFlux 사용 상황
- 외부 I/O와 동시 요청이 많을 때
- 대기 상황이 상대적으로 긴 환경
- 대기 중인 스레드 낭비를 줄일 수 있다.
  - WebFlux, Reactor Netty -> non-blocking, event-driven, backpressure-ready
- CPU bound 작업이 주된 서비스 -> WebFlux가 정답이 아닐 수도 있다. -> non-blocking 효과가 큰데, 중간에 blocking 호출이 많으면 이점이 크게 줄어든다.
- 예시
  - 여러 외부 API를 조합하는 게이트웨이/집계 API
  - 실시간 스트리밍/이벤트 처리
  - WebSocket, SSE 같은 지속 연결
  - high concurrency 환경 I/O bound 서비스

## WebFlux - WebSocket
- WebFlux는 웹 소켓과 같은 지속 연결 모델과 궁합이 좋다.
- 동시 연결 수 + 리소스 효율이 MVC에 비해 좋다.
  - 연결 수 + I/O 대기 + 트래픽 -> 커지면 WebFlux가 유리하다.
  - MVC
    - 요청/처리 흐름이 blocking 스타일 -> DB, 외부 API 호출 있으면 thread 묶임
    - 내부적으로 thread-per-request 모델 영향 받음 
    - thread pool 커짐 -> context switching 증가
    - 유저 메시지 -> 서버 -> DB 저장(blocking)
      - 스레드 점유, 브로드캐스트
  - WebFlux
    - non-blocking / event loop 기반(Netty)
    - 소수 thread (event loop) 처리
    - I/O 대기중 thread 반환
    - 메시지 이벤트만 처리
    - 유저 메시지 -> 서버 -> DB 호출 (non-blocking)
      - 스레드 반환
      - 완료시 이어서 처리

