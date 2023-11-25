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
        final int CNST = 1000000;
        System.out.println("Time taken to execute parse(): " 
                + elapsedTime / CNST + " miliseconds");

        return result;
    }
}
