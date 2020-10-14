package com.HM.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.HM.dao.RIMMapper;
import com.HM.entity.Rno;
import com.HM.entity.Room;

import util.SessionUtil;

public class RIMservice {
	
     public List<Room> findAll(){
		
		SqlSession session = SessionUtil.getSession();
		RIMMapper mapper  = session.getMapper(RIMMapper.class);
		return mapper.findAll();
		
     }	
		public Room findRe(String rno){
			SqlSession session = SessionUtil.getSession();
			RIMMapper mapper  = session.getMapper(RIMMapper.class);
			return mapper.findRe(rno);
		}
		
		public void insert(String rno ,String size,String rent,String state) {
			SqlSession session = SessionUtil.getSession();
			RIMMapper mapper  = session.getMapper(RIMMapper.class);
			mapper.insert(rno, size, rent,state);
			session.commit();
		    session.close();
		}
				
		
		public void deleteRI(String rno) {
			SqlSession session = SessionUtil.getSession();
			RIMMapper mapper  = session.getMapper(RIMMapper.class);
			mapper.deleteRI(rno);
			session.commit();
		    session.close();
		}
		
		public void updateRI(String rno,String size,String rent) {
			SqlSession session = SessionUtil.getSession();
			RIMMapper mapper  = session.getMapper(RIMMapper.class);
			mapper.updateRI(rno,size,rent);
			session.commit();
		    session.close();
		}
		

}
