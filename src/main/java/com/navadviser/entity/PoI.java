package com.navadviser.entity;

import lombok.*;
import com.navadviser.entity.PoiType;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PoI {
    private String id;
    private PoiType type;
    private String name;
    private double latitude;
    private double longitude;

    private Description description;
    private PoIServices services;
    private Constrains constrains;

    private Contacts contacts;
    private List<Review> reviews;

    @Data
    @NoArgsConstructor
    private static class Description {
        private String shortDesc;
        private String longDesc;
    }

    @Data
    @NoArgsConstructor
    private static class PoIServices {
        private Boolean electricity;
        private Boolean water;
        private Boolean diesel;
        private Boolean repair;
        private Boolean toilet;
        private Boolean shower;
    }

    @Data
    @NoArgsConstructor
    private static class Constrains {
        private Double maxLength;
        private Double maxWidth;
        private Double maxDraft;
    }

    @Data
    @NoArgsConstructor
    private static class Contacts {
        private String url;
        private List<String> phones;
        private List<ContactPerson> contactPersons;
        private String email;
        private Integer vhfChannel;

        @Data
        @NoArgsConstructor
        private static class ContactPerson {
            private String name;
            private String phone;
        }
    }

    @Data
    @NoArgsConstructor
    private static class Review {
        private String user;
        private String reviewText;
        private Integer rating;
    }
}
