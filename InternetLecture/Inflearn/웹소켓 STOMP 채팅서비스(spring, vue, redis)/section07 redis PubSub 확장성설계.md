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
- BE/FE 각 2개 씩 -> 일반 크롬, 시크릿 크롬으로 user1/user2 구분
  - pubsub을 공유 자원으로 잘 쓰는지 체크
- 카프카/레디스 차이점
  - redis
    - 더 빠른 성능 보장
    - 레디스가 연결된 서버에 쏴줄 때, 뻗어있는 서비스의 유저는 메시지를 받지 못한다.
      - 레디스에 메시지를 저장하지 않는다. -> 메시지 유실
  - kafka
    - 더 안정적인 메시징 처리
    - 메시지를 저장
      - 뻗은 서버가 있다면, 살아날 때 다시 전송! -> 성능은 떨어질 수 밖에 없다.
        - 추후 전송 가능 -> 채팅보단, 서버간 MSA 아키텍처에서 이벤트 드리븐(A -> B API를 카프카를 통해 호출) 
          - MSA에서 빈번, 요청이 유실되면 안 되기에 카프카에 저장해서 쓰는 이벤트 드리븐! 
