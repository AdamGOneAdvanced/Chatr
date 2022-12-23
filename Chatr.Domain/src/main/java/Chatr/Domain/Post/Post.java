package Chatr.Domain.Post;

import Chatr.Domain.Comment.Comment;
import Chatr.Domain.Entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Post {
    private Entity entity;
    private PostValueObject valueObject;

    public Post(UUID id, String content, Date date) {
        entity = new Entity(id);
        valueObject = new PostValueObject(content, date, null);
    }

    public void changeId(UUID id) {
        entity = new Entity(id);
    }

    public UUID getId() {
        return entity.getId();
    }

    public void changeContent(String content) {
        valueObject = new PostValueObject(content, valueObject.getDate(), valueObject.getComments());
    }

    public void changeDate(Date date) {
        valueObject = new PostValueObject(valueObject.getContent(), date, valueObject.getComments());
    }

    public void addComment(Comment comment) {
        List<Comment> comments = valueObject.getComments();
        comments.add(comment);
        valueObject = new PostValueObject(valueObject.getContent(), valueObject.getDate(), comments);
    }

    public String getContent() {
        return valueObject.getContent();
    }

    public Date getDate() {
        return valueObject.getDate();
    }

    public List<Comment> getComments() {
        return valueObject.getComments();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Post post)){
            return false;
        }
        return valueObject.equals(post.valueObject);
    }

    @Override
    public int hashCode(){
        return valueObject.hashCode();
    }
}
