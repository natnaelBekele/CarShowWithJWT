package com.binary.dtos;

import lombok.Getter;

@Getter
public class AuthenticationResponseDto {

    private final String token;

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

}
