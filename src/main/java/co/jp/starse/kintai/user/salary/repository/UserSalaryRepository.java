package co.jp.starse.kintai.user.salary.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface UserSalaryRepository {
	
	public ArrayList<Users> getAllUser();
}
