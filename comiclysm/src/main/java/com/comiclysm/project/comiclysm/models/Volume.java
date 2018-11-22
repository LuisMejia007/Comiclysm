package com.comiclysm.project.comiclysm.models;

import javax.persistence.*;

@Entity
@Table(name = "volume")
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="volume_id")
    int volumeId;


    @Column(name = "volume_name")
    String volumeName;

    @Column(name = "volume_publisher_id")
    int volumePublisherId;

    @Column(name = "volume_img")
    String volumeImg;

    public Volume() {}

    public Volume(String volumeName, int volumePublisherId) {
        this.volumeName = volumeName;
        this.volumePublisherId = volumePublisherId;
    }


    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }


    public void setVolumePublisherId(int volumePublisherId) {
        this.volumePublisherId = volumePublisherId;
    }

    public int getVolumePublisherId() {
        return volumePublisherId;
    }

    public String getVolumeImg() {
        return volumeImg;
    }

    public void setVolumeImg(String volumeImg) {
        this.volumeImg = volumeImg;
    }
}
