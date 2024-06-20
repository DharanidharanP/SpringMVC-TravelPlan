package com.parablu.travel.Dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Component
public class TravelDaoImpl implements TravelDao{

	
	@Override
	public String travelPostData(String userName, String place) {
		System.out.println("dao impl is calling ");
		 String connectionString = "mongodb://localhost:27017";
	     try (MongoClient mongoClient = MongoClients.create(connectionString)) {
	         System.out.println("Connected to MongoDB.");

	         MongoDatabase database = mongoClient.getDatabase("TRAVEL");
	        
	          userName = userName + "_TRAVEL";
	          System.out.println(userName);
	        

	         Document queryFilter = new Document("place", place);
	         MongoCollection<Document> dharani_Travel = database.getCollection(userName);

	         if (place.equals("Namakkal")) {
	       	  System.out.println("NAMAKKAL condision sucess");
	        MongoCollection<Document> allTravelCollection = database.getCollection("ALL_TRAVEL");
	        FindIterable<Document> allTravelDocuments = allTravelCollection.find(queryFilter);
	        for (Document document : allTravelDocuments) {
	       	 System.out.println("NAMAKKAL check insert ");
	     	   dharani_Travel.insertOne(document);
	     	 System.out.println("NAMAKKAL  insert Success ");
	     	 
	        }
	            
	         } else if (place.equals("Bengalore")) {
	            MongoCollection<Document> allTravelCollection = database.getCollection("ALL_TRAVEL");
	   	       FindIterable<Document> allTravelDocuments = allTravelCollection.find(queryFilter);
	   	     //  Document queryFilter1 = new Document("place", place);
	   	       for (Document document : allTravelDocuments) {
	   	    	   dharani_Travel.insertOne(document);
	   	       }
	         } else if (place.equals("Chennai")) {
	         	 MongoCollection<Document> allTravelCollection = database.getCollection("ALL_TRAVEL");
	   	         FindIterable<Document> allTravelDocuments = allTravelCollection.find(queryFilter);
	   	         for (Document document : allTravelDocuments) {
	   	    	 dharani_Travel.insertOne(document);  
	   	       }
	         }

	         return "Collection created and data inserted successfully.";

	     } catch (Exception e) {
	         System.err.println("Failed to connect to MongoDB: " + e);
	     }
		return "Failed to connect to MongoDB";
	}

	@Override
	public List<Document> travelGetData(String userName) {
		 String connectionString = "mongodb://localhost:27017";
	     String databaseName = "TRAVEL";
	     String collectionName = userName + "_TRAVEL";
	     
	     try (MongoClient mongoClient = MongoClients.create(connectionString)) {
	         MongoDatabase database = mongoClient.getDatabase(databaseName);
	         MongoCollection<Document> userCollection = database.getCollection(collectionName);
	         System.out.println("before user data");
	         
	         List<Document> userDataList = new ArrayList<>();
	         
	         MongoCursor<Document> cursor = userCollection.find().iterator();
				
				while (cursor.hasNext()) {
					Document userData = cursor.next();
					userDataList.add(userData);
				}
				
	         System.out.println("After user data");
	     		
				if (!userDataList.isEmpty()) {
					System.out.println("User Data: " + userDataList);
					return userDataList;
				} else {

					System.out.println("User not found");
					return userDataList ;
				}
				 

	     } catch (Exception e) {
	         e.printStackTrace();
	         return Collections.emptyList(); 
	     }
	}
	
	
}
