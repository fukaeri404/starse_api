package co.jp.starse.kintai.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface AuthRepository {
	public Users findByEmail(@Param("mail") String mail);
	
	public Users getUserByEamil(@Param("mail") String mail);
	
	public void changePassword(@Param("password") String password);
	
	
}
