package com.andrew.hnt.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {

    public String userId;    // 사용자 아이디
    public String userPass;    // 사용자 비밀번호
}
