package com.cslc.MongoPackage;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Connect {
    public MongoDatabase database;
    public MongoClient mongoClient;

    public void getConnection() {
        try {
            String connectionString =
             "mongodb://admin:root@127.0.0.1:27017/?authSource=admin";
            mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase("mydb"); // Replace "mydb" with your MongoDB database name
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
    }

    /*public void executeSelectQuery(String collectionName, Document query) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            // Here you can perform find operations using query
            // For example:
            // FindIterable<Document> result = collection.find(query);
            // Process the result as needed
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void executeUpdateQuery(String collectionName, Document filter, Document update) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            // Here you can perform update operations using filter and update documents
            // For example:
            // collection.updateOne(filter, update);
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/

    public void closeConnection() {
        try {
            mongoClient.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}