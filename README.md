# InvestApiPoject

## Contents
- 전체 투자상품 조회, 투자하기, 나의 투자상품 조회가 가능한 API를 구현한다.
- 요청한 사용자 식별값은 숫자 형태이며 "X-USER-ID" 라는 HTTP Header로 전달된다.

## Logic
- data.sql을 통해 SpringBoot실행시 H2에 관련 테이블이 생성되고, Insert 될 수 있도록 한다.
- InvestApiController을 통해 각 URI에 해당되는 Service 호출이 가능하도록 한다.
- **Model**
  - Goods : 투자상품 관련 정보를 저장한다.
  - Invest : user와 user가 투자한 정보를 저장한다.
- **Repository**
  - GoodsRepository : 투자상품 관련 정보를 가져온다.
    - findByStartedAtBeforeAndFinishedAtAfter : 투자시작일시와 투자종료일시 사이에 있는 투자정보를 가져오기 위함.
    - findByTitle : prePersistTest 테스트를 위해 만듬.
  - InvestRepository : 투자자의 투자상품 관련 정보를 가져온다.
    - findByUserId : 투자자의 투자 상품을 가져오기 위함.
    - findByUserIdAndGoodsId : 투자자가 투자한 특정 상품을 업데이트하기 위함.
- **Service**
  - InvestService : 투자 상품 조회, 업데이트 등 간단한 작업들을 수행한다.
  - MyInvestService : 나의 투자상품 조회 시, 투자자의 투자 정보와 각 투자Id에 해당되는 투자 상품을 조회하여 List<MyInvestGoods>로 리턴하는 로직을 수행한다.
  - UpdateInvestService : 투자하기 시, 투자상품과 유저투자정보 update 후, 해당하는 GoodsStatus로 리턴하는 로직을 수행한다.
- **Response**
  - MyInvestGoods : 나의 투자상품 조회 시, builder를 통해 투자자의 투자 정보와 해당되는 투자 상품을 리턴하는 데 필요한 정보 리턴할 수 있도록 한다.
  - GoodsStatus : CONTINUE(투자가능), COMPLETE(모집완료), SOLD_OUT(투자금액 초과) ENUM으로 정의


## Development Environment
- Java 11
- SpringBoot 2.4.5
- H2
- JPA


## Test URI
- 전체 투자상품 조회 : localhost:8080/invest/goods
- 투자하기 : localhost:8080/invest/put/1/1000000
- 나의 투자상품 조회 : localhost:8080/invest/my_goods
