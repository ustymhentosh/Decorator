package com.example.flower;

import com.example.flower.document.CachedDocument;
import com.example.flower.document.Document;
import com.example.flower.document.SmartDocument;
import com.example.flower.document.TimedDocument;

public class DocumentScannerTest {
    public static void main(String[] args) {
        Document documentOne = new TimedDocument(
                        new CachedDocument(
                        new SmartDocument("path-to-the-file")));
        System.out.println(documentOne.parse());
    }
}