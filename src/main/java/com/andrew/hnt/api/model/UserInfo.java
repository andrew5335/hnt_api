package com.andrew.hnt.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    public int no;    // 번호 - 사용자 고유 아이디
    public String userNm;    // 사용자명
    public String userTel;    // 사용자 전화번호
    public String userEmail;    // 사용자 메일주소
    public String userId;    // 사용자 아이디
    public String userPass;    // 사용자 비밀번호
    public String userGrade;    // 사용자 등급 - A : Admin / U : User
    public String useYn;    // 사용 여부
    public String delYn;    // 삭제 여부
    public String instId;    // 입력자 아이디
    public String mdfId;    // 수정자 아이디
}
