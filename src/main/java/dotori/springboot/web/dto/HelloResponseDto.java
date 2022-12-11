package dotori.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter   // 모든 필드에 대해 get 메서드 생성
@RequiredArgsConstructor   // 모든 final 필드가 포함된 생성자 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
