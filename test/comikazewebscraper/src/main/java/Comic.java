import java.lang.reflect.Array;
import java.util.ArrayList;

public class Comic {



    String comicVolume;
    ArrayList<String> issues = new ArrayList<String>();
    ArrayList<String> info = new ArrayList<String>();
    String comicName;
    String publisher;
    String publicationDate;
    String writer;
    String artist;
    String imgUrl;


    public Comic (){ }



    public void addComic(String comicName) {
        this.issues.add(comicName);
    }

    public void setComicVolume(String comicVolume) {
        this.comicVolume = comicVolume;
    }

    public void setComicBookName(String comicBookName) {
        this.comicName = comicBookName;
    }

    public void addInfo(String info) {
        this.info.add(info);
    }

    public String getComicVolume() {
        return comicVolume;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void printInfo() {
        System.out.print(this.writer + ",");
        System.out.print(this.artist + ",");
        System.out.print(this.imgUrl);
        System.out.println();
    }

    public String getComicBookVol() {
        return this.comicVolume;
    }

    public String getComicBookName() {
        return this.comicName;
    }

    public ArrayList<String> getComicBookIssues () {
        return this.issues;
    }

    public void getIssues() {
        for (String comic: this.issues) {
            System.out.println(comic);
        }
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public void copyInfo(ArrayList<String> info) {
        this.info = info;
    }
}
