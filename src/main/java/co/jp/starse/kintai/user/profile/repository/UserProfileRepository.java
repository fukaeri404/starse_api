package co.jp.starse.kintai.user.profile.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface UserProfileRepository {
	
	public ArrayList<Users> getAllUser();
}
