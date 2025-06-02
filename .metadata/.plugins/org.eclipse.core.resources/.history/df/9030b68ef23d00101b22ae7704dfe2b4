package com.Pets.Platform.Kafka;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.Pets.Platform.Redis.Redis_Services;
import com.Pets.Platform.mongo.Chat;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Consumer_Services {
	
	@Autowired
	private Chat Mongo;
	
	@Autowired
	private Redis_Services Redis;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @KafkaListener(topics = "SendChat", groupId = "chat-consumer-group")
    public void listen(ConsumerRecord<String, String> record, Acknowledgment ack) {
      logger.info("보낸 메시지 :" + record.value());

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> chat = mapper.readValue(record.value(), Map.class);
            ack.acknowledge();
            logger.info("send 변환  :" + chat);
            Redis.CountChat(chat.get("MessageId").toString() , chat.get("ReCount").toString());
            Mongo.Insert_ChatInfo(chat);
            
        } catch (Exception e) {
            logger.error("❌ 메시지 파싱 실패", e);
        }	
    }
    
    @KafkaListener(topics = "ChatRead", groupId = "Read-Consumer")
    public void ReadChat(ConsumerRecord<String, String> record, Acknowledgment ack) {
        logger.info("읽음 :" + record.value());

        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> chat = mapper.readValue(record.value(), Map.class);
            ack.acknowledge();
            logger.info("read 변환 :" + chat);
            Mongo.ReadChat(chat);
        } catch (Exception e) {
            logger.error("❌ 메시지 파싱 실패", e);
        }	
    }
    
    

}
