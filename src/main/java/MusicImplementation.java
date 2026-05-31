import java.util.Date;

public class MusicImplementation implements Music {
    private String title;
    private String artist;
    private double duration;
    private String description;
    private long id;
    private Date releaseDate;

    public MusicImplementation(String title, String artist, double duration, String description, long id, Date releaseDate) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.description = description;
        this.id = id;
        this.releaseDate = releaseDate;
    }

    public MusicImplementation(String title, long id) {
        this(title, "FZ", 2.52, "description", id, new Date());
    }
    public MusicImplementation() {
        this("title", "FZ", 2.52, "description", 42l, new Date());
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public double getDuration() {
        return this.duration;
    }

    public String getArtist() {
        return this.artist;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public String toString() {
        return "[" + this.id + "]: \"" + this.title + "\" (" + this.getDescription() + ") " + " by " + this.artist
                + " on " + this.releaseDate.getYear() + " duration: " + ((int) this.getDuration()) + ":" + (int) ((this.getDuration() % 1) * 60) + " min";
    }

    @Override
    // Beispielaufruf für die Funtkion precedes arr[x].precedes(arr[y])
    public boolean precedes(Sortable s) {
        // optional (it would be wrong to try and compare it to something else)
        if (!(s instanceof MusicImplementation)) {
            return false;
        }
        // TODO: 1.1a
        int title_precedes = this.getTitle().compareTo(((MusicImplementation) s).getTitle());
        boolean duration_equals = this.getDuration() == ((MusicImplementation) s).getDuration();
        boolean duration_precedes = this.getDuration() < ((MusicImplementation) s).getDuration();
        boolean id_precedes = this.getId() < ((MusicImplementation) s).getId();

        if (title_precedes < 0){
            return true;
        } else if (title_precedes == 0) {
            if (duration_precedes) {
                return true;
            } else if (duration_equals) {
                if (id_precedes) {
                    return true;
                }
            }
        }
        return false;
    }
}
