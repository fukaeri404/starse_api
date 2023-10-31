package co.jp.starse.kintai.admin.kinmu.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.admin.kinmu.entity.CalendarDetailEntity;
import co.jp.starse.kintai.admin.kinmu.entity.CalendarEntity;
import co.jp.starse.kintai.admin.kinmu.entity.KinmuBasicEntity;
import co.jp.starse.kintai.entity.Users;

@Mapper
public interface KinmuRepository {

	public ArrayList<Users> getAllUser();
	
	public void register(KinmuBasicEntity kinmuBasic);
	
	public void registerCalendar(CalendarEntity calendar);
	
	ArrayList<CalendarDetailEntity> getCalendarDetailByYear(Integer year);
}
