
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;



public class Main {



    public static ArrayList<ComicVolume> comics = new ArrayList<ComicVolume>();

    public static void getDCComicVolumes(String url) {

        System.out.println(url);


        try {
            final Document doc = Jsoup.connect(url).get();

            // For-loop will loop inside the parent element specified within the arguments inside doc.select(...)
            for(Element comic_vols : doc.select("div.mw-content-ltr table tr td ul li")) {


                String comicbookVol = comic_vols.getElementsByTag("a").text();
                comicbookVol = comicbookVol.replace(" ", "_");
                getDCComicIssues(comicbookVol);
            }



        } catch(Exception e) {

        }
    }


    public static void getDCComicIssues(String comicBookVol) {

        String url = "http://dc.wikia.com/wiki/" + comicBookVol;
        ArrayList<String> comicBookIssues = new ArrayList<String>();

        ComicVolume comicVolume = new ComicVolume();

        comicVolume.setComicVolumeName(comicBookVol);

        try {
            final Document doc = Jsoup.connect(url).get();

            Elements elements = doc.select("div.mw-content-ltr ul");
            Element firstComicList = elements.first();
            firstComicList.addClass("comicList");

            for (Element comicBookElement : firstComicList.getElementsByTag("a")) {
                String comicBookIssue = comicBookElement.text();
                Comic comic = new Comic();
                comic.setComicVolume(comicBookVol);
                comic.setComicBookName(comicBookIssue);
                comicVolume.addIssue(comic);
            }

            comics.add(comicVolume);

            getDCComicIssueInfo(comicVolume);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getDCComicIssueInfo (ComicVolume comicVol) {

//        String url = "http://dc.wikia.com/wiki/Wonder_Woman_Vol_5_1";
        ArrayList<String>comicUrls = new ArrayList<String>();

        int counter = 1;
        for (Comic issues : comicVol.getIssues()) {
            String comicUrl ="http://dc.wikia.com/wiki/" +  comicVol.comicVolume + "_" + counter;
            comicUrls.add(comicUrl);
            counter++;
        }

        ArrayList<String> comicInfo = new ArrayList<String>();

        int issueCounter = 0;

        int num_counter = 0;
        for (String url: comicUrls) {

            try {
                final Document doc = Jsoup.connect(url).get();

                for (Element comic : doc.select("section.pi-item div.pi-item div.hlist")) {

                    String comicImg = " blank";
                    String comicWriter = comic.getElementsByTag("a").first().text();;



                    comicVol.issues.get(issueCounter).setWriter(comicWriter);
                    comicVol.issues.get(issueCounter).setImgUrl(comicImg);

                    num_counter++;

                    // We only want about two creators at a time (keeping it simple as possible)
                    if (num_counter >= 2) {
                        break;
                    }
                }

                num_counter = 0;

                for (Element comic : doc.select("section.pi-item div.pi-item div.hlist")) {


                    String comicArtist = comic.firstElementSibling().nextElementSibling().getElementsByTag("a").text();
                    System.out.println("Artist: " + comicArtist);
                    comicVol.issues.get(issueCounter).setArtist(comicArtist);

                    num_counter++;

                    // We only want about two creators at a time (keeping it simple as possible)
                    if (num_counter >= 2) {
                        break;
                    }

                }


                issueCounter++;
                num_counter = 0;
            }  catch(Exception E) {

            }
        }
        issueCounter = 0;
    }

    public static void printAllMyComics() {

        for (ComicVolume comic: comics) {
            System.out.print(comic.comicVolume + ",");
            comic.printIssues();
        }
    }

    public static void printComicBookNames(ArrayList<String> comics) {
        System.out.println("Comics length: " + comics.size());
        for (String comic: comics) {
            System.out.println("Comic: " + comic);
        }
    }
    public static void main(String args[]){
        System.out.println("Hello World!!!!!");
        String url = "http://dc.wikia.com/wiki/Category:Volumes_Currently_in_Publication?display=page&sort=mostvisited";
        getDCComicVolumes(url);
        printAllMyComics();
    }
}
