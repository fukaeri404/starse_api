package co.jp.starse.kintai.admin.kinmu.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface KinmuRepository {

	public ArrayList<Users> getAllUser();
}
