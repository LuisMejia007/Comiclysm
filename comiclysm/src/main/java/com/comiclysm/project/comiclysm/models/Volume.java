package com.comiclysm.project.comiclysm.models;

import java.util.List;

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

//    @Column(name = "volume_publisher_id")
//    int volumePublisherId;

    @ManyToOne
    @JoinColumn(name = "volume_publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "volume")
    private List<Comic> comicsByVol;

    public Volume() {}

    public Volume(String volumeName, int volumePublisherId) {
        this.volumeName = volumeName;
        //this.volumePublisherId = volumePublisherId;
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


//    public void setVolumePublisherId(int volumePublisherId) {
//        this.volumePublisherId = volumePublisherId;
//    }
//
//    public int getVolumePublisherId() {
//        return volumePublisherId;
//    }


}
