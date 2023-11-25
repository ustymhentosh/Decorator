package com.example.flower.document;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;
import com.google.cloud.vision.v1.TextAnnotation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SmartDocument implements Document {
    public String gcsPath;

    public void SaveToDB(String somePath, String text) {
        try (Jedis jedis = new Jedis("localhost")) {
            System.out.println("adding to database");
            jedis.set(somePath, text);
        }
    }

    @SneakyThrows
    public String parse() {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ImageSource imgSource = ImageSource.newBuilder().setGcsImageUri(gcsPath).build();
        Image img = Image.newBuilder().setSource(imgSource).build();
        Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();
            client.close();

            for (AnnotateImageResponse res : responses) {
                TextAnnotation annotation = res.getFullTextAnnotation();
                String text = annotation.getText();
                SaveToDB(gcsPath, text);
                return text;
            }
        }
        SaveToDB(gcsPath, "");
        return "";
    }
}