package game;

import game.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    TelegramRepository telegramRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverUsed_Use(@Payload Sended sended){

        if(sended.isMe()){
            System.out.println("##### listener Use : " + sended.toJson());

            Telegram telegram = new Telegram();
            telegram.setGiftId(sended.getId());
            telegram.setStatus(sended.getStatus());

            telegramRepository.save(telegram);
        }
    }

}
