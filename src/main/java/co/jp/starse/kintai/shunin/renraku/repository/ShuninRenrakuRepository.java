package co.jp.starse.kintai.shunin.renraku.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface ShuninRenrakuRepository {

	public ArrayList<Users> getAllUser();
}
