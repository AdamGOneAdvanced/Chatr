package Chatr.Domain.Post;

import Chatr.Domain.Entity;

import java.util.Date;
import java.util.UUID;

public class Post {
    private Entity entity;
    private PostValueObject valueObject;

    public Post(UUID id, String content, Date date) {
        entity = new Entity(id);
        valueObject = new PostValueObject(content, date);
    }

    public void changeId(UUID id) {
        entity = new Entity(id);
    }

    public UUID getId() {
        return entity.getId();
    }

    public void changeContent(String content){
        valueObject = new PostValueObject(content, valueObject.getDate());
    }

    public void changeDate(Date date){
        valueObject = new PostValueObject(valueObject.getContent(), date);
    }

    public String getContent(){
        return valueObject.getContent();
    }

    public Date getDate(){
        return valueObject.getDate();
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
