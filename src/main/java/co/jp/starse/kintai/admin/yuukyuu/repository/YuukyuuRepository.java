package co.jp.starse.kintai.admin.yuukyuu.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface YuukyuuRepository {
	
	public ArrayList<Users> getAllUser();


}
