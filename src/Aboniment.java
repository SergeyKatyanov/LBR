import java.util.List;

public class Aboniment {

    private Students Students_id;

    private List<TextBooks> TextBooks_id;

    public Students getStudents_id() {return Students_id;}

    public void setStudents(Students Students_id){this.Students_id = Students_id;}

    public List<TextBooks> getTextBooks() {
        return TextBooks_id;
    }

    public void setTextBooks(List<TextBooks> TextBooks) {
        this.TextBooks_id = TextBooks_id;
    }
}

