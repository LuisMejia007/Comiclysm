import java.util.ArrayList;

public class ComicVolume {

    String comicVolume;
    int volumePublisherId;

    ArrayList<Comic> issues = new ArrayList<Comic>();


    public ComicVolume() {
        this.volumePublisherId = 0;
    }

    public void setComicVolumeName(String comicVolume) {
        this.comicVolume = comicVolume;
    }

    public String getComicVolume() {
        return comicVolume;
    }

    public int getVolumePublisherId() {
        return volumePublisherId;
    }

    public void setVolumePublisherId(int volumePublisherId) {
        this.volumePublisherId = volumePublisherId;
    }

    public void addIssue(Comic comic) {
        this.issues.add(comic);
    }

    public ArrayList<Comic> getIssues() {
        return this.issues;
    }

    public void printIssues() {
        System.out.println();

        for(Comic comic:  this.issues) {
            comic.printInfo();
        }
    }
}
