# Saga pattern
- 하나의 DB 트랜잭션으로 묶기 어렵기 때문에, 각 서비스가 로컬 트랜잭션을 수행 후 실패시 보상 작업으로 복구 할 수 있다.
- 두 가지 방식
  1. Choreography Saga -> 각 서비스가 event를 보고 다음 행동을 스스로 결정하는 구조
  2. Orchestration Saga -> 중앙 오케스트레이터가 전체 흐름을 제어하는 구조
- 예시 도메인
  - Order
  - Inventory
  - Payment
- Choreography Saga 설계
  - OrderService -> OrderCreated
    - InventoryService -> 

# TCC pattern
