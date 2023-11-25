package com.example.flower;

import com.example.flower.document.CachedDocument;
import com.example.flower.document.Document;
import com.example.flower.document.SmartDocument;
import com.example.flower.document.TimedDocument;

public class DocumentScannerTest {
    public static void main(String[] args) {
        Document document_1 = new TimedDocument(new CachedDocument(new SmartDocument("gs://dir73/Strategy.png")));
        System.out.println(document_1.parse());
    }
}
