package co.jp.starse.kintai.admin.account.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface AccountRepository {
	
	public ArrayList<Users> getAllUser();
}
