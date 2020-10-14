package com.HM.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.HM.dao.FIMMapper;
import com.HM.entity.FStuff;

import util.SessionUtil;

public class FIMservice {
	
	public List<FStuff> findAll(){
		
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		return mapper.findAll();
		
	}
	
	public FStuff findRe(String no){
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		return mapper.findRe(no);
	}
	
	public void insert(String no ,String password,String name) {
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		mapper.insert(no, password, name);
		session.commit();
	    session.close();
	}
	
	public void deleteFI(String no) {
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		mapper.deleteFI(no);
		session.commit();
	    session.close();
	}
	
	public void updateFI(String no,String password) {
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		mapper.updateFI(no,password);
		session.commit();
	    session.close();
	}
	
	public List<FStuff> FICBylastname(String lastname){
		SqlSession session = SessionUtil.getSession();
		FIMMapper mapper  = session.getMapper(FIMMapper.class);
		return mapper.FICBylastname(lastname);
	}

}
