package hust.soict.dsai.test.polymorphism;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;
public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1,"Noi ay con tim ve","Nhac dan ca", 18.5f,"Ho Quan Hieu",97);
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("happy",3));
        tracks.add(new Track("i love u",4));
        CompactDisc cd = new CompactDisc(2,"mot minh anh noi dau cho em","that tinh",25.5f,"Khanh",tracks);
        List<String> authors = new ArrayList<String>();
        authors.add(" Huy Le");
        authors.add("Hieu Vu");
        Book book   = new Book(3,"chuyen tinh anh va em ngay ay","tuoi tre",25.2f,authors);

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for(Media item : mediae) {
            System.out.println(item);
        }
    }
}