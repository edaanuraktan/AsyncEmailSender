package com.mycompany.asyncemailsender;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailWorker {
    public static void processEmails() {
        MongoCollection<Document> emailCollection = DatabaseConnector.getEmailCollection("emailCollection");
        MongoCollection<Document> subjectContentCollection = DatabaseConnector.getEmailCollection("subjectContentCollection");

        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 iş parçacığı

        // Rastgele e-postalar seçildi
        AggregateIterable<Document> randomEmails = emailCollection.aggregate(
                Arrays.asList(new Document("$sample", new Document("size", 10)))
        );

        for (Document email : randomEmails) {
            executor.submit(() -> {
                // Rastgele bir konu ve içerik seçildi
                Document randomSubjectContent = subjectContentCollection.aggregate(
                        Arrays.asList(new Document("$sample", new Document("size", 1)))
                ).first();

                if (randomSubjectContent != null) {
                    String to = email.getString("email");
                    String subject = randomSubjectContent.getString("subject");
                    String content = randomSubjectContent.getString("content");

                    EmailSender.sendEmail(to, subject, content);
                }
            });
        }

        executor.shutdown();
    }
}
