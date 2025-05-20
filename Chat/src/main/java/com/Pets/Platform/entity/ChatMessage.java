package com.Pets.Platform.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Document(collection = "Message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    private String chatId;
    private String sendId;
    private String message;
    private String timestamp; // 필요시
    private String profile;
    private String nickname;
    private List<String> inviteIds;
    private int recount;
    private String messageId;
    private List<String> rdMember;

    // ✅ 기본 생성자, getter/setter
    public ChatMessage() {}
    
    public void setRdMember(List<String> rdMember) {
      	 this.rdMember = rdMember;
      }
      
      public List<String> getRdMember() {
      	return rdMember;
      }
    
    public void setMessageId(String messageId) {
   	 this.messageId = messageId;
   }
   
   public String getMessageId() {
   	return messageId;
   }
    
    public void setRecount(int recount) {
   	 this.recount = recount;
   }
   
   public int getRecount() {
   	return recount;
   }
    
    public void setNickname(String nickname) {
    	 this.nickname = nickname;
    }
    
    public String getNickname() {
    	return nickname;
    }
    
    public void setInviteIds(List<String> inviteIds) {
    	this.inviteIds = inviteIds;
    }
    
    public List<String> getInviteIds(){
    	return inviteIds;
    }
    
    public String getProfile() {
    	return profile;
    }
    
    public void setProfile(String profile) {
    	this.profile = profile;
    }

    public String getChatId() {
        return chatId;
    }
    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSendId() {
        return sendId;
    }
    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
