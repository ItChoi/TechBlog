# 6. 도메인구성

## ERD 구성
- 회원 (member)
- 메시지읽음 (message_read_status)
- 채팅메시지 (chat_message)
- 채팅참여자 (chat_participant)
- 채팅방 (chat_room)

# 7. 회원가입

# 8. filterchain 설정
- cors
  - 백엔드 도메인 -> localhost:8080
  - 프론트 도메인 -> localhost:3000
  - web role -> 같은 도메인이 아니면 통신 X

# JWT 토큰 생성
- jwt token
  - header
    - 알고리즘, 타입 지정 (토큰 메타 정보)
  - payload
    - 실질적인 데이터 (이름, 이메일, role, ...)
    - 노출되면 안 되는 정보는 X
  - signature
    - 토큰이 만들어진 서버 검증 
    - header.payload.secretkey
    - 인코딩 -> 복호화 가능
    - 시그니쳐 부분 복호화 불가 -> SHA256


  




