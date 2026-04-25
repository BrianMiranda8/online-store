package org.example.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptLogger {
    private String content;


    public ReceiptLogger(String content) {
        this.content = content;
    }

    public void generateReceipt(){
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedFileName = today.format(fmt);


        try(BufferedWriter writer = new BufferedWriter(new FileWriter("receipts/"+formattedFileName+".txt"))){
            writer.write(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
