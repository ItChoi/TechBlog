# 23. entity erd설계
- member
  - id
  - name
  - email
  - password
- message_read_status
  - id
  - message_id
  - member_id
  - chat_room_id
  - isRead
- chat_message
  - id
  - chat_room_id
  - member_id
  - content
- chat_room
  - id
  - isGroupChat
  - name
- chat_participant
  - id
  - chat_room_id
  - member_id

# 24. api기본구성


# 25. 채팅메시지저장
- api 목록
  - 메시지 저장 (saveMessage)
  - 그룹 채팅 관련
    - 채팅방 개설
    - 채팅 목록 조회
    - 채팅 참여자 추가
  - 1:1 채팅 관련
    - 개인 채팅방 개설
  - 공통 처리
    - 이전 메시지 내역 조회
    - 채팅방 메시지 읽음 처리
    - 내 채팅방 목록 조회

# 26. 그룹채팅방개설

# 27. 그룹채팅목록

# 28. 그룹채팅목록(화면)

# 29. 이전메시지조회

# 30. 메시지읽음처리, 채팅방나가기

# 31. 메시지읽음처리, 채팅방나가기(화면)

# 32. 1:1채팅구현


