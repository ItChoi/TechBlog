# 베이스 이미지 명시
FROM alpine

# 추가적으로 필요한 파일 다운
RUN #command

# 컨테이너 시작시 실행할 명령어
#CMD ["excutable"]
CMD ["echo", "hello"]