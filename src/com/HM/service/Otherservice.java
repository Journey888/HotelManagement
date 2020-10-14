package com.HM.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.HM.dao.OtherMapper;
import com.HM.dao.RIMMapper;
import com.HM.entity.Arrange;
import com.HM.entity.Client;
import com.HM.entity.Form;
import com.HM.entity.RReserveF;
import com.HM.entity.Rno;

import util.SessionUtil;

public class Otherservice {
	
	
	public List<RReserveF> findDate(String rno){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.findDate(rno);		
	}

	public List<Rno> findRno(String size){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.findRno(size);		
		
	}
	
	public List<Rno> findFree(String size){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.findFree(size);
	}
	
	public List<RReserveF> findAllRe() {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		return mapper.findAllRe();
	}
	
	public List<RReserveF> findAllRes() {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		return mapper.findAllRes();
	}
	
	public RReserveF findbyId (String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		return mapper.findbyId(idcard);
	}
	
	public void insertRF(String rno,String name,String idcard,String startdate,String enddate,String size,String rent) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		mapper.insertRF(rno,name,idcard,startdate,enddate,size,rent);
		session.commit();
	    session.close();
	}
	
	public void insertForm(String rno,String name,String idcard,String startdate,String enddate,String size,String rent,double earnings) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		mapper.insertForm(rno,name,idcard,startdate,enddate,size,rent,earnings);
		session.commit();
	    session.close();
	}
	
	public void deleteReserve(String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		mapper.deleteReserve(idcard);
		session.commit();
	    session.close();
	}
	
	public void setRoomState(String state, String rno) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		mapper.setRoomState(rno, state);
		session.commit();
	    session.close();
	}
	
	public void updateClientleft(String state,String rno, String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		mapper.updateClientleft(state, rno,idcard);
		session.commit();
	    session.close();
	}
	
	public void updateClient( String idcard ,String rno,String name,String sex,String phone,String email,String state) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper = session.getMapper(OtherMapper.class);
		mapper.updateClient( idcard,rno,name,sex,phone,email,state);
		session.commit();
	    session.close();
	}
	
	
	public void insertClient(String name ,String sex, String phone ,String email ,String rno ,String idcard ,String state) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		mapper.insertClient(name, sex, phone, email, rno, idcard, state);
		session.commit();
	    session.close();
	}
	
	public Client findClient(String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.findClient(idcard);
	}
	
	public void updateClientState(String state,String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		mapper.updateClientState(state,idcard);
		session.commit();
	    session.close();
	}
	
	public List<Client> selectByname(String name) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectByname(name);
	}
	
	public List<Client> selectByidcard(String idcard) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectByidcard(idcard);
	}
	
	public List<Client> selectByphone(String phone) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectByphone(phone);
	}
	
	public List<Client> selectByemail(String email) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectByemail(email);
	}
	
	public List<Client> selectByrno(String rno) {
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectByrno(rno);
	}
	
	public List<RReserveF> selectcheckout(String enddate){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectcheckout(enddate);
	}
	
	public List<Form> selectForm (String startdate,String enddate){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectForm(startdate,enddate);
	}
	
	public List<Arrange> selectArrange(){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectArrange();
	}
	
	public List<Client> selectBylastname(String lastname){
		SqlSession session = SessionUtil.getSession();
		OtherMapper mapper  = session.getMapper(OtherMapper.class);
		return mapper.selectBylastname(lastname);
	}
	
}
