package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuctionUser implements Serializable{
	private Integer userId;// �û����
	private String userName;// �û���
	private String userPassword;// �û�����
	private String userCardNo;// �û����֤��
	private String userTel;// �û��绰
	private String userAddress;// �û���ַ
	private String userPostNumber;// �û��������
	private Integer userIsadmin = 0;// �û��Ƿ��ǹ���Ա��0�Ǿ����ߣ�1�ǹ���Ա��Ĭ��ֵ��0
	private String userQuestion;// �û��һ����������
	private String userAnswer;// �û��һ������
	private List<AuctionRecord> auctionRecords = new ArrayList<AuctionRecord>();

	public AuctionUser() {
	}

	public AuctionUser(Integer userId, String userName, String userPassword,
			String userCardNo, String userTel, String userAddress,
			String userPostNumber, Integer userIsadmin, String userQuestion,
			String userAnswer) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCardNo = userCardNo;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userPostNumber = userPostNumber;
		this.userIsadmin = userIsadmin;
		this.userQuestion = userQuestion;
		this.userAnswer = userAnswer;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCardNo() {
		return userCardNo;
	}

	public void setUserCardNo(String userCardNo) {
		this.userCardNo = userCardNo;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostNumber() {
		return userPostNumber;
	}

	public void setUserPostNumber(String userPostNumber) {
		this.userPostNumber = userPostNumber;
	}

	public Integer getUserIsadmin() {
		return userIsadmin;
	}

	public void setUserIsadmin(Integer userIsadmin) {
		this.userIsadmin = userIsadmin;
	}

	public String getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public List<AuctionRecord> getAuctionRecords() {
		return auctionRecords;
	}

	public void setAuctionRecords(List<AuctionRecord> auctionRecords) {
		this.auctionRecords = auctionRecords;
	}

}
