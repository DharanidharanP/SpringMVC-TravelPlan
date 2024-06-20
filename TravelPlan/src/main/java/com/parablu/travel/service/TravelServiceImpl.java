package com.parablu.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parablu.travel.Dao.TravelDao;

@Component
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelDao travelDao;
	

	public TravelDao getTravelDao() {
		return travelDao;
	}


	public void setTravelDao(TravelDao travelDao) {
		this.travelDao = travelDao;
	}

	@Override
	public String travelPostService(String userName, String place) {
      System.out.println("travelServiceImpl");
		
		travelDao.travelPostData(userName,place);
		return null;
	}


	@Override
	public String travelGetService(String userName) {
		travelDao.travelGetData(userName);
		return null;
	}


		

}
