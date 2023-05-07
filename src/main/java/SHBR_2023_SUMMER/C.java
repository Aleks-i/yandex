package SHBR_2023_SUMMER;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class C {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        int[] str = Arrays.stream(strings.get(0).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        strings.remove(0);

        int n = str[0];
        int m = str[1];

        TreeMap<Integer, Set<String>> trigers = new TreeMap<>();
        for (int i = 0; i < n; i++){
            if (!trigers.containsKey(i)) {
                trigers.put(i, new HashSet<>());
            }
            String[] tr = strings.get(0).split(" ");
            for (int j = 2; j < tr.length; j++) {
                trigers.get(i).add(tr[j]);
            }
            strings.remove(0);
        }

        List<Message> messages = new ArrayList<>();
        while (m != 0) {
            Message message = objectMapper.readValue(strings.get(0), Message.class);
            Message newMessage = new Message();
            newMessage.setTrace_id(message.trace_id);
            newMessage.getOffer().setId(message.getOffer().id);
            trigers.forEach((k, v) -> {

            });


            strings.remove(0);
            m--;
        }
    }

    private static class Message {
        String trace_id;
        Offer offer;

        public String getTrace_id() {
            return trace_id;
        }

        public void setTrace_id(String trace_id) {
            this.trace_id = trace_id;
        }

        public Offer getOffer() {
            return offer;
        }

        public void setOffer(Offer offer) {
            this.offer = offer;
        }
    }
    private static class Offer {
        String id;
        Integer price;
        Integer stock_count;

        PartnerContent partnerContent;
        public Offer() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getStock_count() {
            return stock_count;
        }

        public void setStock_count(Integer stock_count) {
            this.stock_count = stock_count;
        }

        public PartnerContent getPartnerContent() {
            return partnerContent;
        }

        @JsonSetter("partner_content")
        public void setPartnerContent(PartnerContent partnerContent) {
            this.partnerContent = partnerContent;
        }
    }
    private static class PartnerContent {
        String title;

        String description;
        public PartnerContent() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
