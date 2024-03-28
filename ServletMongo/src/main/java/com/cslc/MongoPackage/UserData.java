package com.cslc.MongoPackage;
import org.bson.Document;

public class UserData {
    private Connect con;

    public UserData() {
        con = new Connect();
        con.getConnection();
    }
    public void storeUserCredentials(String user_name, String user_password) {
        try {
            // Create a new document to store user credentials
            Document document = new Document("user_name", user_name)
                                    .append("user_password", user_password);
            // Specify the collection where the document will be stored
            String collectionName = "user_credentials";
            // Insert the document into the collection
            con.insertDocument(collectionName, document);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viewUserCredentials() {
        
    }
}