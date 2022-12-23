package Chatr.Domain.Post;

import java.util.Date;
import java.util.Objects;

public class PostValueObject {

    private String content;
    private Date date;

    protected PostValueObject(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate(){
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostValueObject that)) return false;
        return Objects.equals(content, that.content) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, date);
    }
}
