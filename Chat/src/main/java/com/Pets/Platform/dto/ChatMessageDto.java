package com.Pets.Platform.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessageDto {
    private Long id;  // 메시지 ID

    private String message;  // 메시지 내용
    private String userId;  // 보낸 사용자 ID
    private String sendDate;  // 전송 일자

    private List<String> readUser;  // 메시지를 읽은 사용자 리스트
    private int rdCount;  // 읽지 않은 메시지 수
}
