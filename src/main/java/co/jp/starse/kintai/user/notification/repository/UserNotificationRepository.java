package co.jp.starse.kintai.user.notification.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface UserNotificationRepository {
	
	public ArrayList<Users> getAllUser();
}
