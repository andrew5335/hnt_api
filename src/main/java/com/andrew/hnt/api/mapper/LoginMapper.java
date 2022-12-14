package com.andrew.hnt.api.mapper;

import java.util.Map;

import com.andrew.hnt.api.model.LoginVO;
import com.andrew.hnt.api.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

	public UserInfo getUserInfo(LoginVO loginVO);

	public void insertUser(UserInfo userInfo);
}
