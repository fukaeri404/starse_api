package co.jp.starse.kintai.admin.payslip.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface PayslipRepository {
	
	public ArrayList<Users> getAllUser();

}
