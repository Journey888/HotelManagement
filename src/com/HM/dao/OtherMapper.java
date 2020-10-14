package com.HM.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.HM.entity.Arrange;
import com.HM.entity.Client;
import com.HM.entity.Form;
import com.HM.entity.RReserveF;
import com.HM.entity.Rno;

public interface OtherMapper {
	
	//查询某一房间的预约情况
	@Select("SELECT * from rreserve WHERE rno = #{v} ORDER BY startdate asc;")
	public List<RReserveF> findDate(String rno);
	
	//查询预约表里满足大小要求的房间号
	@Select("SELECT DISTINCT rno, rent from rreserve where size = #{v} ORDER BY rno asc")
	public List<Rno> findRno(String size);
	
	//查询空闲的且大小符合要求的房间
	@Select("select rno,rent FROM `room` where state ='空闲' and size=#{v}")
    public List<Rno> findFree(String size);
	
	@Insert("insert into `rreserve` values(#{rno},#{name},#{idcard},#{startdate},#{enddate},#{size},#{rent})")
	public void insertRF(@Param("rno")String rno,
			@Param("name")String name,
			@Param("idcard")String idcard,
			@Param("startdate")String startdate,
			@Param("enddate")String enddate,
			@Param("size")String size,
			@Param("rent")String rent
			);

	@Select("select * from rreserve order by startdate desc")
	public List<RReserveF> findAllRe();
	
	@Select("select * from rreserve order by rno asc")
	public List<RReserveF> findAllRes();
	
	@Select("select * from client where idcard =#{v}")
	public Client findClient(String idcard);
	
	@Select("select * from rreserve where idcard =#{v}")
	public RReserveF findbyId(String idcard);
	
	@Delete("delete from rreserve where idcard = #{v}")
	public void deleteReserve(String idcard);
	
	@Update("update `room` set state = #{state}  where rno =#{rno}")
	public void setRoomState( @Param("rno")String rno,
			@Param("state")String state);
	
	@Insert("insert into `client` values(#{name},#{sex},#{phone},#{email},#{rno},#{idcard},#{state})")
	public void insertClient(@Param("name")String name,
			@Param("sex")String sex,
			@Param("phone")String phone,
			@Param("email")String email,
			@Param("rno")String rno,
			@Param("idcard")String idcard,
			@Param("state")String state
			);
	@Update("update `client` set state =#{state},rno =#{rno} where idcard =#{idcard}")
	public void updateClientleft(@Param("state")String state,
			@Param("rno")String rno,
			@Param("idcard")String idcard);
	
	@Update("update `client` set rno =#{rno},name=#{name},sex=#{sex},phone=#{phone},email=#{email},state=#{state} where idcard =#{idcard}")
	public void updateClient(@Param("idcard")String idcard,
			@Param("rno")String rno,
			@Param("name")String name,
			@Param("sex")String sex,
			@Param("phone")String phone,
			@Param("email")String email,
			@Param("state")String state);
	
	@Update("update `client` set state= #{state} where idcard =#{idcard}")
	public void updateClientState(@Param("state")String state,
			@Param("idcard")String idcard);
	
	@Select("select * from `client` where name=#{v}")
	public List<Client> selectByname(String name);
	
	@Select("select * from `client` where idcard=#{v}")
	public List<Client> selectByidcard(String idcard);
	
	@Select("select * from `client` where phone=#{v}")
	public List<Client> selectByphone(String phone);
	
	@Select("select * from `client` where email=#{v}")
	public List<Client> selectByemail(String email);
	
	@Select("select * from `client` where rno=#{v}")
	public List<Client> selectByrno(String rno);
	
	@Insert("insert into `form` values(#{rno},#{name},#{idcard},#{startdate},#{enddate},#{size},#{rent},#{earnings})")
	public void insertForm(@Param("rno")String rno,
			@Param("name")String name,
			@Param("idcard")String idcard,
			@Param("startdate")String startdate,
			@Param("enddate")String enddate,
			@Param("size")String size,
			@Param("rent")String rent,
			@Param("earnings")double earnings);
	
	@Select("select * from `rreserve` where enddate =#{v}")
	public List<RReserveF> selectcheckout(String enddate);
	
	@Select("select * from `form` where startdate>=#{startdate} and enddate<=#{enddate} order by startdate desc")
	public List<Form> selectForm(@Param("startdate")String startdate,
			@Param("enddate")String enddate);
	
	@Select("select room.rno,room.size,room.rent,rreserve.name,state,startdate,enddate from room left join rreserve on room.rno=rreserve.rno order by rno asc")
	public List<Arrange> selectArrange();
	
	@Select("select * from client where name like #{v};")
	public List<Client> selectBylastname(String lastname);
}

