package com.HM.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.HM.entity.FStuff;


public interface FIMMapper {
	
	//查看前台操作员信息
	@Select("select * from `fstuff`")
	public List<FStuff> findAll();
	
	//按用户名查找
	@Select("select * from `fstuff` where no = #{v}")
	public FStuff findRe(String no);
	
	@Insert("insert into `fstuff` values(#{no},#{password},#{name})")
	public void insert(@Param("no")String no,
			@Param("password")String password,
			@Param("name")String name
			);
	
	@Delete("delete from `fstuff` where no =#{v}")
	public void deleteFI(String no);
	
	@Update("update `fstuff` set password = #{password} where no = #{no}")
	public void updateFI( @Param("no")String no,
			@Param("password")String password);
	
	@Select("select * from `fstuff` where name like #{v}")
	public List<FStuff> FICBylastname(String lastname);

}
