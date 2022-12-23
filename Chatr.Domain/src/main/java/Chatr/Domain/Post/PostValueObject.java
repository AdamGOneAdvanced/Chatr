package Chatr.Domain.Post;

import Chatr.Domain.Comment.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PostValueObject {

    private String content;
    private Date date;
    private List<Comment> comments;

    protected PostValueObject(String content, Date date, List<Comment> comments) {
        this.content = content;
        this.date = date;
        this.comments = comments == null ? new ArrayList<Comment>() : comments;
    }

    public String getContent() {
        return content;
    }

    public Date getDate(){
        return date;
    }

    public List<Comment> getComments() {
        return comments;
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
