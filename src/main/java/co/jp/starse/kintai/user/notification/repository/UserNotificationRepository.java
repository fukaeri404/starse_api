package co.jp.starse.kintai.user.notification.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import co.jp.starse.kintai.entity.Users;
import co.jp.starse.kintai.user.notification.entity.UserNotificationEntity;

@Mapper
public interface UserNotificationRepository {
	
	public ArrayList<Users> getAllUser();
	
	public ArrayList<UserNotificationEntity> getNotificationById(@Param("user_id") String userId);

}
