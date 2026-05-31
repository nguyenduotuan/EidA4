
/*
 * angelehnt an https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
 */
public interface Sortable {

    /**
     * @return true if to should be after to according to the internal order else false
     */
    public boolean precedes(Sortable s);

}
