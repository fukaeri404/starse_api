package co.jp.starse.kintai.admin.kubun.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface KubunRepository {

	public ArrayList<Users> getAllUser();
}
