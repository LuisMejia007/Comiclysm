import java.lang.reflect.Array;
import java.util.ArrayList;

public class Comic {



    String comicVolume;
    ArrayList<String> issues = new ArrayList<String>();
    ArrayList<String> info = new ArrayList<String>();
    int comicId;
    int comicInventoryId;
    int comicTradeId;
    String comicName;
    String publisher;
    String publicationDate;
    String writer;
    String artist;
    String imgUrl;
    String comicInfo;


    public Comic () {
        this.comicId = 0;
        this.comicInventoryId = 0;
        this.comicTradeId = 0;
    }



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
        System.out.print(this.comicId + ",");
        System.out.print(this.comicName + ",");
        System.out.print(this.writer + ",");
        System.out.print(this.artist + ",");
        System.out.print(this.publicationDate + ",");
        System.out.print(this.imgUrl + ",");
        System.out.print(this.comicVolume + ",");
        System.out.print(this.comicTradeId + ",");
        System.out.print(this.comicInventoryId);
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

    public String getComicInfo() {
        return comicInfo;
    }

    public void setComicInfo(String comicInfo) {
        this.comicInfo = comicInfo;
    }
}
