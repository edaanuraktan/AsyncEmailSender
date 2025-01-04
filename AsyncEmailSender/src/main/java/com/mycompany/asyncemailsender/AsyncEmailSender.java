/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.asyncemailsender;

/**
 *
 * @author Damla
 */
public class AsyncEmailSender {

    public static void main(String[] args) {
        System.out.println("Starting email processing...");
        EmailWorker.processEmails();
        System.out.println("Email processing completed.");
    }
}
