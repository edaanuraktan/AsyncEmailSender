package com.mycompany.asyncemailsender;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseConnector {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "emailDB";

    public static MongoCollection<Document> getEmailCollection(String collectionName) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(URI));
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        return database.getCollection(collectionName);
    }
}
