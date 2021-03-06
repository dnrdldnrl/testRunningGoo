package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javassem.domain.MemberVO;
import com.javassem.domain.RunningGooRoomNumberVO;
import com.javassem.domain.RunningGooVO;

@Repository
public interface RunningGooDAO {
	// 런닝구 방 정보 입력
	void createRngRoom(RunningGooVO vo);
	
	// 런닝구 방 리스트 불러오기
	public List<RunningGooVO> getRNRoomList(RunningGooVO vo);
	
	// 런닝구 방 갯수 얻어오기
	int getRunningGooRoomCount(RunningGooVO vo);
	
	// 런닝구 방 생성 시 멤버 보유 포인트 얻어오기
	public int getRngMemberPoints(MemberVO vo);
	
	// doJoin 눌렀을때 insert되는 멤버 정보
	RunningGooVO bringBasicRngRoomInfo(RunningGooVO vo);
	
	// 참여자가 DoJoin을 눌렀을때 들어가는 멤버정보
	void CreateRunningGooMemberInsert(RunningGooVO vo);
	
	// 호스트에게 보여질 수락이 완료된 멤버들의 정보
	List<HashMap<String,Object>> viewJoinMemberList(int roomNum);
	
	// 호스트에게 보여질 수락을 기다리는 참여자들의 간단한 정보
	List<HashMap<String,Object>> viewNotYetJoinMemberList(int roomNum);
	
	// 호스트가 수락을 눌렀을때 수정될 런닝구 멤버의 정보
	void upateRngMemberInfo(HashMap<String,Object> map);
}
