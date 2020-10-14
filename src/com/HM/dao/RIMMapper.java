package com.HM.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.HM.entity.Rno;
import com.HM.entity.Room;


public interface RIMMapper {
	
	@Select("select * from `room`")
	public List<Room> findAll();
	
	//按用户名查找
	@Select("select * from `room` where rno = #{v}")
	public Room findRe(String Rno);
		
	@Insert("insert into `room` values(#{rno},#{size},#{rent},#{state})")
	public void insert(@Param("rno")String rno,
			@Param("size")String size,
			@Param("rent")String rent,
			@Param("state")String state
			);
    
    @Delete("delete from `room` where rno =#{v}")
	public void deleteRI(String rno);
	
	@Update("update `room` set size = #{size},rent=#{rent} where rno = #{rno}")
	public void updateRI( @Param("rno")String rno,
			@Param("size")String size,
			@Param("rent")String rent);

}
