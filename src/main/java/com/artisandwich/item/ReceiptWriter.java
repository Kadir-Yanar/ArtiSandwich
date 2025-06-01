package com.artisandwich.item;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(String receiptText) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = "receipts/" + timestamp + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(receiptText);
            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt.");
        }
    }
}