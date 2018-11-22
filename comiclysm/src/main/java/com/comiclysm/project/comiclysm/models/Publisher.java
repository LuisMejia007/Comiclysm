package com.comiclysm.project.comiclysm.models;


import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    int publisherId;

    @Column(name = "publisher_name")
    String publisherName;


    public Publisher() {}

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
