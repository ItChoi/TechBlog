# global traffic
- 무작정 CDN, 멀티 리전, 오토스케일링만 외우지 않기
- 글로벌 유저 -> 지연(latency), 가용성, 데티어 일관성, 비용 -> 균형있게 설계 필요
  - 어디서 처리할지
  - 어디서 저장할지
  - 지역별 Data
  - base 저장소가 필요한지

## 글로벌 트래픽 대응 -> 대표 이슈 네 가지
1. 지연 시간
   - 한귝 유저 -> 서울 리전 요청시 빠르다.
   - 미국 유저 -> 서울 리전 요청시 느리다.
     - 물리적 거리, 네트워크 hop, TLS handshake, 왕복 시간(RTT)이 늘어난다.
2. 트래픽 집중
3. 데이터 정합성
   - 같은 데이터 동시 수정시 이슈 발생 -> 재고, 좌석, 템플릿 최신 버전, 결제 상태
   - 단순 캐시로 해결 X
4. 장애 대응
   - 단일 리전 장애시 글로벌 영향 
   - 글로벌 대응 -> 성능 뿐만 아니라 DR/가용성 문제

--- 

## 글로벌 트래픽 대응 큰 축
- 5단계 정리
1. 정적 컨텐츠 분산
   - 이미지, JS, CSS, 템플릿 썸네일, ... -> 매번 원본 리전에서 내려주면 네트워크 비용 크다.
   - CDN / Edge cache -> 가까운 edge에서 응답
2. 읽기 트래픽 분산
   - regional read
   - cache
   - replica
3. 쓰기 트래픽 처리 전략
   - single write
   - multi-region write
   - event-driven
4. 라우팅 전략
   - geo routing
   - latency routing
   - failover routing
5. 데이터 일관성 전략
   - strong consistency 필요한 영역
   - eventual consistency 허용 영역 분리