package com.artisandwich.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void writeReceipt(String receiptText) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String filePath = "src/main/resources/receipt/"+ "Receipt_" + timestamp + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(receiptText);
            System.out.println("Receipt saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}