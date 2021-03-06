package com.example.ThriftyFriend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.scheduling.annotation.EnableScheduling;


@Entity
@Table(name="summaryHistoryLogs")
public class SummaryHistoryLog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double averageCost;
	private double minCost;
	private double maxCost;
	
	@Column(updatable=false)
	private Date createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="summary_id")
	private ListingSummary summary;
	
	@PrePersist
	protected void createdAt()
	{
		this.createdAt = new Date();
	}
		
	public SummaryHistoryLog()
	{
		
	}
	
	public SummaryHistoryLog(String name, double averageCost, double minCost, double maxCost)
	{
		this.name = name;
		this.averageCost = averageCost;
		this.minCost = minCost;
		this.maxCost = maxCost;
	}
	
	public void refresh()
	{
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverageCost() {
		return averageCost;
	}
	public void setAverageCost(double averageCost) {
		this.averageCost = averageCost;
	}
	public double getMinCost() {
		return minCost;
	}
	public void setMinCost(double minCost) {
		this.minCost = minCost;
	}
	public double getMaxCost() {
		return maxCost;
	}
	public void setMaxCost(double maxCost) {
		this.maxCost = maxCost;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public ListingSummary getSummary() {
		return summary;
	}

	public void setSummary(ListingSummary summary) {
		this.summary = summary;
	}
}
