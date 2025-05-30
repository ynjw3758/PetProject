package com.Pets.Platform.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ChatUerinfoDto {
	
    private String Userid;  // 유저 ID
    private String Nickname;  //  닉네임
    private String Img;
    private List<String> ChatRoom;
}
