package co.jp.starse.kintai.admin.group.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface GroupRepository {

	public ArrayList<Users> getAllUser();
}
