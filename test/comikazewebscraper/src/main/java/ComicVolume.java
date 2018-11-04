import java.util.ArrayList;

public class ComicVolume {

    String comicVolume;
    ArrayList<Comic> issues = new ArrayList<Comic>();


    public ComicVolume() {}

    public void setComicVolumeName(String comicVolume) {
        this.comicVolume = comicVolume;
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
