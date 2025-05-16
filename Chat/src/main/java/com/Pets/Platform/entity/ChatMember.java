package com.Pets.Platform.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMember {
	
	private LocalDateTime CreateDate;
	
	@Field("chat_Id")
	private String Chat;
	
	private List<Map<String, Object>> Members;
	
    public void ChatMember(List<Map<String, Object>> Members, String Chat, LocalDateTime CreateDate) {
        this.Members = Members;
        this.Chat = Chat;
        this.CreateDate = CreateDate;
    }
    
    public void setCreateDate(LocalDateTime CreateDate) {
    	this.CreateDate = CreateDate;
    }
    
    public LocalDateTime getCreateDate() {
    	return CreateDate;
    }
    
    public void setChat(String Chat) {
    	this.Chat = Chat;
    }
    
    public String getChat() {
    	return Chat;
    }
    
    public void setMembers(List<Map<String, Object>> Members) {
    	this.Members = Members;
    }
    
    public List<Map<String, Object>> getMembers(){
    	return Members;
    }
}
