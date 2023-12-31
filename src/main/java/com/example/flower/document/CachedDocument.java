package com.example.flower.document;

import redis.clients.jedis.Jedis;

public class CachedDocument implements Document {
    private SmartDocument wrappedDocument;
    private String url = "localhost";

    public CachedDocument(SmartDocument wrappedDocument) {
        this.wrappedDocument = wrappedDocument;
    }

    @Override
    public String parse() {
        String searchPath = this.wrappedDocument.getGcsPath();
        String result;
        try (Jedis JEDIS = new Jedis(url)) {
            result = JEDIS.get(searchPath);
        }
        if (result != null) {
            System.out.println("result found in db, returning value");
            return result;

        } else {
            System.out.println("result not found in db, parsing...");
            return wrappedDocument.parse();
        }
    }
}
