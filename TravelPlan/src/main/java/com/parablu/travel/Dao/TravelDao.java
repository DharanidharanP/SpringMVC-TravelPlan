package com.parablu.travel.Dao;

import java.util.List;

import org.bson.Document;

public interface TravelDao {

	public String travelPostData(String userName, String place);
	public List<Document> travelGetData(String userName);
}
