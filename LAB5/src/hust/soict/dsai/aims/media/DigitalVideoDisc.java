package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(int id, String title, String category, float cost , String director, float length){
        super(id, title, category, cost, director, length);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public void play() throws PlayerException {
        if (this.getLength() < 0){
            throw new PlayerException("ERROR: DVD-length is non-positive!");
        } else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }
}