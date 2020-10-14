package com.HM.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.HM.entity.BStuff;
import com.HM.entity.FStuff;

public interface LoginMapper {

	//登录方法
	@Select("SELECT * FROM `fstuff` WHERE no = #{no}  AND `password`= #{psw} ")
	public FStuff login0( @Param("no") String no , 
					    @Param("psw")String password); 
	@Select("SELECT * FROM `bstuff` WHERE no = #{no}  AND `password`= #{psw} ")
	public BStuff login1( @Param("no") String no , 
					    @Param("psw")String password); 
	

}
