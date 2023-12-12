package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(loadData());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:8080/csv/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.print("Response Status:");
        System.out.print(response.statusCode());
    }


    public static List<Row> loadData() throws FileNotFoundException {
        String delimiter = ",";
        String line;
        List<Row> values = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("src/main/resources/data.csv"))) {
            while ((line = br.readLine()) != null) {
                var fields = (line.split(delimiter));
                values.add(new Row(Long.valueOf(fields[0].trim()),
                        fields[1].trim(),
                        fields[2].trim(),
                        fields[3].trim(),
                        fields[4].trim(),
                        fields[5].trim(),
                        fields[6].trim(),
                        fields[7].trim()
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return values;
    }

    private record Row(Long customerRef,
                       String customerName,
                       String addressLine1,
                       String addressLine2,
                       String town,
                       String county,
                       String country,
                       String postcode) {
    }
}
