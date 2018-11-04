
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

//        Ex: String url = "http://dc.wikia.com/wiki/Wonder_Woman_Vol_5_1";
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

                // Get Comic Book Writers and Artists
                for (Element comic: doc.select("div.container ul.categories")) {
                     List<String> creators = comic.getElementsByClass("category normal").eachAttr("data-name");

                     boolean isAWriter = false;
                     boolean isAnArtist = false;
                     for (String creator: creators ) {
                         isAWriter = creator.contains("Writer");
                         if (isAWriter) {
                             creator = creator.replace("/Writer", "");
                             comicVol.issues.get(issueCounter).setWriter(creator);
                             break;
                         }
                    }

                    for (String creator: creators) {
                         isAnArtist = creator.contains("Cover Artist");
                          if (isAnArtist) {
                            creator = creator.replace("/Cover Artist", "");
                            comicVol.issues.get(issueCounter).setArtist(creator);
                            break;
                        }

                     }

                    for (Element comicImg: doc.select("figure.pi-image a.image-thumbnail")) {

                        String imgUrl = comicImg.getElementsByAttribute("title").first().attr("href");
                        comicVol.issues.get(issueCounter).setImgUrl(imgUrl);
                        break;
                    }

                    for(Element comicDate: doc.select("h2.pi-title.pi-item-spacing.pi-item:nth-of-type(3)")) {
                        comicVol.issues.get(issueCounter).setPublicationDate(comicDate.text());
                    }

                num_counter = 0;
                issueCounter++;
                }


            }  catch(Exception E) {
                System.out.println(E);
            }
        }
    }

    public static void printAllMyComics() {

        for (ComicVolume comic: comics) {
            System.out.println(comic.comicVolume + ",");
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
