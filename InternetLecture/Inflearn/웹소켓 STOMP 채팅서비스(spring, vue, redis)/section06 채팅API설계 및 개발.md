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
TODO

# 26. 그룹채팅방개설

# 27. 그룹채팅목록

# 28. 그룹채팅목록(화면)

# 29. 이전메시지조회

# 30. 메시지읽음처리, 채팅방나가기

# 31. 메시지읽음처리, 채팅방나가기(화면)

# 32. 1:1채팅구현


