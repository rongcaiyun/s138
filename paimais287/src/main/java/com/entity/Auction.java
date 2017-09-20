package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ����Ʒ��
 * @author doubles
 *
 */
public class Auction implements Serializable{
	private Integer auctionId;//����Ʒ���
	private String auctionName;//����Ʒ����
	private Double auctionStartPrice=0.0;//����Ʒ���ļ�
	private String auctionUpSet;//����Ʒ�׼�
	private String auctionStartTime;//����Ʒ������ʼʱ��
    private String auctionEndTime;//����Ʒ��������ʱ��
    private String auctionPic;//����ƷͼƬ·��
    private String auctionPicType;//����ƷͼƬ��չ��
    private String auctionDesc;//����Ʒ����
    private List<AuctionRecord> auctionRecords=new ArrayList<AuctionRecord>();
    
    public Auction(){}
	public Auction(Integer auctionId, String auctionName,
			Double auctionStartPrice, String auctionUpSet,
			String auctionStartTime, String auctionEndTime, String auctionPic,
			String auctionPicType, String auctionDesc) {
		this.auctionId = auctionId;
		this.auctionName = auctionName;
		this.auctionStartPrice = auctionStartPrice;
		this.auctionUpSet = auctionUpSet;
		this.auctionStartTime = auctionStartTime;
		this.auctionEndTime = auctionEndTime;
		this.auctionPic = auctionPic;
		this.auctionPicType = auctionPicType;
		this.auctionDesc = auctionDesc;
	}
	public Integer getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}
	public String getAuctionName() {
		return auctionName;
	}
	public void setAuctionName(String auctionName) {
		this.auctionName = auctionName;
	}
	public Double getAuctionStartPrice() {
		return auctionStartPrice;
	}
	public void setAuctionStartPrice(Double auctionStartPrice) {
		this.auctionStartPrice = auctionStartPrice;
	}
	public String getAuctionUpSet() {
		return auctionUpSet;
	}
	public void setAuctionUpSet(String auctionUpSet) {
		this.auctionUpSet = auctionUpSet;
	}
	public String getAuctionStartTime() {
		return auctionStartTime;
	}
	public void setAuctionStartTime(String auctionStartTime) {
		this.auctionStartTime = auctionStartTime;
	}
	public String getAuctionEndTime() {
		return auctionEndTime;
	}
	public void setAuctionEndTime(String auctionEndTime) {
		this.auctionEndTime = auctionEndTime;
	}
	public String getAuctionPic() {
		return auctionPic;
	}
	public void setAuctionPic(String auctionPic) {
		this.auctionPic = auctionPic;
	}
	public String getAuctionPicType() {
		return auctionPicType;
	}
	public void setAuctionPicType(String auctionPicType) {
		this.auctionPicType = auctionPicType;
	}
	public String getAuctionDesc() {
		return auctionDesc;
	}
	public void setAuctionDesc(String auctionDesc) {
		this.auctionDesc = auctionDesc;
	}
	public List<AuctionRecord> getAuctionRecords() {
		return auctionRecords;
	}
	public void setAuctionRecords(List<AuctionRecord> auctionRecords) {
		this.auctionRecords = auctionRecords;
	}
	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", auctionName="
				+ auctionName + ", auctionStartPrice=" + auctionStartPrice
				+ ", auctionUpSet=" + auctionUpSet + ", auctionStartTime="
				+ auctionStartTime + ", auctionEndTime=" + auctionEndTime
				+ ", auctionPic=" + auctionPic + ", auctionPicType="
				+ auctionPicType + ", auctionDesc=" + auctionDesc
				+ ", auctionRecords=" + auctionRecords + "]";
	}
	
}
