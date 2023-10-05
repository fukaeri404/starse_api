package co.jp.starse.kintai.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.starse.kintai.dto.UsersDto;
import co.jp.starse.kintai.entity.Users;

@Mapper
public interface AuthMapper {
	public Users findByEmail(@Param("mail") String mail);
	
	public Users getUserByEmail(@Param("mail") String mail);
	
	public void changePassword(@Param("mail")String mail,@Param("password") String password);
	
	public void register(UsersDto dto);
}
