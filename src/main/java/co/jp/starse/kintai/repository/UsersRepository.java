package co.jp.starse.kintai.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface UsersRepository {
	public Users findByEmail(@Param("email")String email);
}
