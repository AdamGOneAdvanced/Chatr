package Chatr.Domain.Comment;

import Chatr.Domain.Entity;

import java.util.Date;
import java.util.UUID;

public class Comment {

    private Entity entity;
    private CommentValueObject valueObject;

    public Comment(UUID id, String content, Date date){
        entity = new Entity(id);
        valueObject = new CommentValueObject(content, date);
    }

    public UUID getId() {
        return entity.getId();
    }

    public void changeId(UUID id) {
        entity = new Entity(id);
    }

    public void changeContent(String content) {
        valueObject = new CommentValueObject(content, valueObject.getDate());
    }

    public void changeDate(Date date) {
        valueObject = new CommentValueObject(valueObject.getContent(), date);
    }

    public String getContent() {
        return valueObject.getContent();
    }

    public Date getDate() {
        return valueObject.getDate();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Comment comment)) {
            return false;
        }
        return valueObject.equals(comment.valueObject);
    }

    @Override
    public int hashCode(){
        return valueObject.hashCode();
    }

}
