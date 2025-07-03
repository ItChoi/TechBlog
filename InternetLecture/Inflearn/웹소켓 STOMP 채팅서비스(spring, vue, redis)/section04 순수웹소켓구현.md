# 15. 순수웹소켓-백엔드
- 진행 순서
  - 의존성 추가
    - spring-boot-starter-websocket -> 웹 소켓, stomp 등을 포함하고 있는 라이브러리
  - WebSocketConfigurer & WebsocketConfig 추가
    - 기본 Websocket 연결 설정
    - Websocket 엔드포인트(/connect) 설정
  - TextWebSocketHandler 구현체 SimpleWebSocketHandler 생성
    - connect 연결 요청시 해당 요청 처리 클래스
    - 연결전, 연결시, 연결후 처리 손쉽게 진행
  - 채팅 코드 테스트
    - postman -> ws://localhost:8080/ws 엔드포인트로 채팅 실습
- ws 요청을 보내도, filter를 타지만, Authentication 객체를 만들 순 없다.
  - 웹 소켓 내에서 토큰을 받아 인증처리
- CORS
  - http와 websocket 별도
- 테스트
  - websocket -> 포스트맨
  - stomp -> 프론트 화면에서 테스트, 포스트맨에서 지원 안함

# 16. 순수웹소켓-프론트