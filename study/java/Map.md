# Map

## Map이란
- key, value 1:1 매핑 자료구조
- key 중복 X / 값 중복 O

---

## 주요 구현체
- HashMap
  - 해시 기반
  - 순서 보장 X
  - 평균 조회, 삽입 성능 좋음
- LinkedHashMap
  - HashMap + 연결 리스트
  - LRU 캐시 구현에 자주 사용
  - 입력 순서 또는 접근 순서 유지 가능
- TreeMap
  - Red-Black Tree 기반
  - 키가 정렬된 상태로 저장
  - 조회, 삽입, 삭제 -> O(log n)
- Hashtable
  - 오래된 레거시
  - synchronized 기반
- ConcurrentHashMap
  - 멀티 스레드 환경용
  - thread-safe
  - 동시성 제어 고려 해시 기반 Map

---

## HashMap put 흐름
- 1단계: key의 hash 계산
  - key.hashCode() 기반 해시 값 생성
  - Java HashMap -> raw HashCode 바로 사용 X, 상위 비트를 섞는다.

- 서로 다른 key -> 같은 hash 가능, 같은 bucket index 가능