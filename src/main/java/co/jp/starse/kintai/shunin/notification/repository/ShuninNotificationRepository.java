package co.jp.starse.kintai.shunin.notification.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface ShuninNotificationRepository {
	
	public ArrayList<Users> getAllUser();
}
