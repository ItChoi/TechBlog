# HTTP 헤더 개요
```text
HTTP 전송에 필요한 모든 부가 정보가 들어간다
표준 헤더도 많고 커스텀한 헤더도 만들 수 있다.

메시지 본문을 통해 표현 데이터 전달
```

# 표현
```text
회원 리소스를 html, json으로 표현 가능하다.
표현 헤더는 요청, 응답 둘 다 사용 가능하다.

Content-Type: 표현 데이터의 형식
Content-Encoding: 표현 데이터 압축 방식
Content-Language: 표현 데이터의 자연 언어
Content-Length: 표현 데이터 길이 

Content-Type: Content Body에 들어가는 타입을 의미한다. 
Content-Encoding: 데이터 전달 쪽에서 gzip 같은 걸로 압축을 하고, 서버에서 압축을 풀 수 있도록 어떤 형태로 인코딩 했는지 정보도 같이 보내준다.
Content-Language: ko의 경우 한국어가 들어가 있는 걸 파악 가능
Content-Length: 바이트 단위고, Transfer-Encoding(전송 코딩) 사용하는 경우 이 헤더를 사용하면 안된다.
```

# 콘텐츠 협상
```text
클라이언트가 선호하는 표현 요청
협상 헤더는 요청시에만 사용한다.

Accept: 클라이언트가 선호하는 미디어 타입 전달
Accept-Charset: 클라이언트가 선호하는 문자 인코딩
Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
Accept-Language: 클라이언트가 선호하는 자연 언어

Accept-Language: Quality Values를 통해 희망하는 국가 우선 순위를 두어 원하는 응답을 받을 수 있다.
Accept: 구체적인게 가장 우선순위가 높다.  
```

# 전송 방식
```text
네 가지 방식이 있다.
1. 단순 전송(Content-Length): 요청시 응답을 줄 때, 컨텐트에 대한 길이를 알 수 있을 때 쓴다.
2. 압축 전송(Content-Encoding): 내용을 압축하고 클라이언트에서 받아 풀 수 있도록 압축 방식도 같이 내려준다.
3. 분할 전송(Transfer-Encoding): 청크 방식으로 데이터를 쪼개서 보낸다. Hello(5byte) World(5byte) ... / Content-Length가 예상 안되서 보내면 안된다.
4. 범위 전송(Range, Content-Range): 이미지를 중간까지 받다가 끊겼을 때, 끊긴 부분 부터 받을 수 있다.
```


# 일반 정보
```text
From: 유저 에이전트의 이메일 정보 / 검색 엔진 곳에서 주로 사용, 요청에서 사용
Referer: 이전 웹 페이지 주소 / 현재 페이지에서 이전에 요청된 페이지 주소
User-Agent: 유저 에이전트 애플리케이션 정보 / 특정 브라우저에 버그가 생길 때 로그 파싱하면 알 수 있다. 
Server: 요청을 처리하는 오리진 서버의 소프트웨어 정보 / 요청  처리 ORIGIN 서버 소프트 웨어 정보 / HTTP 요청은 여러 프록시 서버를 거치는데, 실제 요청에 대한 응답을 해주는 서버 정보다.
Date: 메시지가 생성된 날짜

단순한 정보성 헤더들이다.
```


# 특별한 정보
```text
Host: 요청한 호스트 정보 (도메인)
Location: 페이지 리다이렉션
Allow: 허용 가능한 HTTP 메서드
Retry-After: 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간

- Host 
리얼 중요! 필수 헤더 값이다. 하나의 서버가 여러 도메인 처리 (하나 IP 주소에 여러 도메인이 있는 경우)
어떤 앱의 요청인지 구분 할 수 있다. (IP 통신인 경우)

- Location
3xx 응답 결과에 Location 헤더가 있으면 이 위치로 redirect된다.  
201에서 Location은 생성된 리소스 URI   

- Allow
허용 가능한 HTTP 메서드

- Retry-After
유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
503 -> 서비스가 언제까지 불능인지 알려줄 수 있다.
날짜 표기 또는 초단위 표기 가능하다. 
```

# 인증
```text
- Authorization
클라이언트 인증 정보를 서버에 전달
Basic xxxxxxxx
인증 방식에 따라 Value에 들어가는 값이 다르다.
인증 실패 -> 401 Unauthorized
401이 나면 WWW-Authentication 헤더를 넣어줘야 한다. 이런 인증 정보를 가지고 헤더를 만들라고 알려주는 것 

- WWW-Authentication
리소스 접근시 필요한 인증 방법 정의 
```


# 쿠키
```text
- Set-Cookie: 서버에서 클라이언트로 쿠키 전달 (응답)
- Cookie
클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달

- Stateless
Http는 무상태 프로토콜이다. 요청에 대한 응답이 주어지면 연결이 끊긴다. 
즉 서버와 클라이언트는 서로 상태를 유지하지 않는다. 

다시보기

```




