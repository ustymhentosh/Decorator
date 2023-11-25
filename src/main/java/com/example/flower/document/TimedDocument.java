package com.example.flower.document;

public class TimedDocument implements Document {
    private Document wrappedDocument;

    public TimedDocument(Document wrappedDocument) {
        this.wrappedDocument = wrappedDocument;
    }

    @Override
    public String parse() {
        long startTime = System.nanoTime();

        String result = wrappedDocument.parse();

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println("Time taken to execute parse(): " 
                + elapsedTime / 1000000 + " miliseconds");

        return result;
    }
}
