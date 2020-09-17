1. telegram > Sended.java 파일을 gift 에 복사
2. gift > Gift.java 추가

    @PostUpdate
    public void onPostUpdate(){
        Used allocated = new Used();
        BeanUtils.copyProperties(this, allocated);
        allocated.publishAfterCommit();
    }

3. 테스트

시나리오
http http://localhost:8088/missions customerId=101 status="Achieved"

http http://localhost:8088/missions/1

http PUT http://localhost:8088/wallets/1 customerId=101 rewardId=1 status="Exchanged"

http http://localhost:8088/gifts/1

http http://localhost:8088/telegram, line/1

http PUT http://localhost:8088/gifts/1 status="Sended" walletId=1

http http://localhost:8088/telegram, line/1
