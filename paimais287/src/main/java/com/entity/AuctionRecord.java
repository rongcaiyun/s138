package com.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ���ļ�¼
 * @author doubles
 *
 */
public class AuctionRecord implements Serializable{
	private Integer id;//���ļ�¼���
	private AuctionUser auctionUser;//������
//	private Integer userId;//�����߱��
//	private Integer auctionId;//����Ʒ���
	private Auction auction;//����Ʒ
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date auctionTime;//����ʱ��
	private Double auctionPrice;//���ļ۸�
	
	public AuctionRecord(){}
	public AuctionRecord(Integer id, Date auctionTime, Double auctionPrice) {
		this.id = id;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAuctionTime() {
		return auctionTime;
	}
	public void setAuctionTime(Date auctionTime) {
		this.auctionTime = auctionTime;
	}
	public Double getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(Double auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public AuctionUser getAuctionUser() {
		return auctionUser;
	}
	public void setAuctionUser(AuctionUser auctionUser) {
		this.auctionUser = auctionUser;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	
}
