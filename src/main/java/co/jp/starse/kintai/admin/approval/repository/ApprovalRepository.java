package co.jp.starse.kintai.admin.approval.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import co.jp.starse.kintai.entity.Users;

@Mapper
public interface ApprovalRepository {

	public ArrayList<Users> getAllUser();
}
