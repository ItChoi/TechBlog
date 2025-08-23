# 33. pub/sub 아키텍처
- 클라이언트A -> /publish/1 -> LB1 -> room1 -> 서버1 <-> redis1 
- 클라이언트B -> /topic/1 -> LB1-> room1 -> 서버2 <-> redis1
- 실시간성
  - 서버 메모리 의존 -> 멀티 서버에서 문제 생길 수도 있음.
  - 써드파티 솔루션 필요 -> 레디스(pub/sub), 카프카, ...
- 구현
  - redis config 생성
    - Lettuce 기반 ConnectionFactory 생성
    - 메시지 발행 -> StringRedisTemplate 생성
    - 특정 채널 구독 -> RedisMessageListenerContainer 생성
    - 수신 메시지 처리 -> MessageListenerAdapter 생성
  - 메시지 송수신 절차
    - api -> 메시지 redis publish
    - 레디스 -> chat 채널에 메시지 발행시 구독중인 RedisMessageListenerContainer가 메시지 수신
    - 수신된 메시지 -> MessageListenerAdapter를 통해 onMessage 메서드로 전달
    - onMessage -> 각 서버의 topic에 메시지 발행 -> subscribe 클라이언트에게 채팅 메시지 전달
  - 카프카 pub/sub 차이점
    - Redis -> 더 빠른 성능 보장
# 34. spring redisconfig설정

# 35. stomp pub/sub 구조변경

# 36. pub/sub 테스트
