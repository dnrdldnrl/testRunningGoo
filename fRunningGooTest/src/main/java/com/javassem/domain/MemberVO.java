package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO {
	private String memberID;
	private String pw;
	private String email;
	private String nickName;
	private String userName;
	private String phoneNumber;
	private String birthday;
	private int gender;
	private int zipCode;
	private String basicAddress;
	private String restAddress;
	private String member_fname;
	private String member_realfname;
	private long member_fsize;
	private int point;
	private char blackListYN;
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getBasicAddress() {
		return basicAddress;
	}
	public void setBasicAddress(String basicAddress) {
		this.basicAddress = basicAddress;
	}
	public String getRestAddress() {
		return restAddress;
	}
	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	public String getMember_fname() {
		return member_fname;
	}
	public void setMember_fname(String member_fname) {
		this.member_fname = member_fname;
	}
	public String getMember_realfname() {
		return member_realfname;
	}
	public void setMember_realfname(String member_realfname) {
		this.member_realfname = member_realfname;
	}
	public long getMember_fsize() {
		return member_fsize;
	}
	public void setMember_fsize(int member_fsize) {
		this.member_fsize = member_fsize;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public char getBlackListYN() {
		return blackListYN;
	}
	public void setBlackListYN(char blackListYN) {
		this.blackListYN = blackListYN;
	}
	
	MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		
		// ????????? ?????? ??????
		if(! file.isEmpty()){
			// b_fname : ???????????? ?????? ?????????
			this.member_fname = file.getOriginalFilename();
			this.member_fsize = file.getSize();
			
			// member_realfname : ????????? ???????????? ?????????
			UUID uuid = UUID.randomUUID();
			// ????????? this??? ???????????? member_realfname ????????????
			this.member_realfname = uuid.toString() + "_" + member_fname;
			
			//***********************************************
			// ?????? ????????? ??????
			//b_fname??? b_realfname?????? ??????
			File f = new File("D:\\springwebs\\Dogether_________________________________________\\src\\main\\webapp\\resources\\upload\\"+member_realfname);
			//File f = new File("webapp\\resources\\upload\\"+member_realfname);
			System.out.println(f.getAbsolutePath());
			//?????? ????????? ?????? ???????????? ????????? ????????????----@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}
