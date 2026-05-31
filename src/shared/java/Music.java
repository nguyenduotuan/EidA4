import java.util.Date;

public interface Music extends Sortable {

    public long getId();

    public String getTitle();

    public double getDuration();

    public String getArtist();

    public String getDescription();

    public Date getReleaseDate();

    public boolean precedes(Sortable s);

}
