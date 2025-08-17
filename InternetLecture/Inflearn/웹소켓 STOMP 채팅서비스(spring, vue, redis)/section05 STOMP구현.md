# 17. stomp config 구성
- stomp
  - 채팅방 그룹핑 가능!
    - 룸 -> topic
      - 토픽에 메시지를 발행하고, 클라이언트가 토픽을 구독해서 메시지를 받아간다.
  - 동작 흐름
    - 클라이언트 -> 서버 커넥트를 맺는다.
    - 클라이언트 메시지 발행 -> 어떤 토픽, 룸에 발행할지 명시해서 서버에 전달
    - 브로커가 메시지를 받아 특정 토픽에 메시지를 발행해준다.
    - 토픽에 메시지 발행, 토픽을 구독하는 사용자한테 메세지 전달!
      - 모든 사용자가 아니라, 특정 토픽을 구독하고, 메시지를 발행하는 사용자 그루핑이 되어 있다.
  - stomp
    - 세션 관리를 서버에서 알아서 관리해주는 편리함.
    - 근간은 ws:// 사용 -> http 요청으로 보낼 수 있다. (SockJS)
      - 웹 소켓 연결을 http 프로토콜 사용 가능
  - Web socket
    - ws:// 
      - 웹 소켓 프로토콜 사용
- 웹 소켓 CORS는 HTTP와 별개로 설정이 필요하다.

# 18. stomp 채팅 화면

# 19. stomp jwt인증 처리
- 인증 여부랑 상관 없이 채팅 메시지를 받는다. -> 토큰 검증 필요

# 22. stomp 마무리
- StompWebSocketConfig implements WebSocketMessageBrokerConfigurer
  - endpoint 설정
  - 메시지 발행, 구독 url 패턴 정의 (prefix)
    - 브로커 역할 -> 메시지 발행, 구독
      - /publish
      - /topic
    - 외뷰 Queue 연동 가능
- ChannelInterceptor implements StompHandler
  - 클라이언트 -> 서버 전송 메시지 인터셉트
    - connect
    - subscribe
    - send
    - disconnect
- StompController
  - MessageMapping, SendTo -> 메시지 라우팅
  - MessageMapping, SimpleMessageSendingOperations.convertAndSend -> 메시지 라우팅 
- EventListener
  - connect, disconnect 체크
  - 연결/해제 이벤트 기록, 세션 수 실시간 조회
- 채팅 코드 테스트
  - WebSocket -> 포스트맨으로 테스트 가능
  - Stomp -> 포스트맨에서 지원하지 않음, FE 구성을 통한 테스트