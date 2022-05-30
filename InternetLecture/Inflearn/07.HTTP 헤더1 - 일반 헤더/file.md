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


