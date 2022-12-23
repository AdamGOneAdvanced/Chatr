package Chatr.Domain.User;

import Chatr.Domain.Entity;

import java.util.UUID;

public class User {

    private Entity entity;
    private UserValueObject valueObject;

    public User(UUID id, String firstName, String lastName) {
        entity = new Entity(id);
        valueObject = new UserValueObject(firstName, lastName);
    }

    public void changeId(UUID id) {
        entity = new Entity(id);
    }

    public UUID getId() {
        return entity.getId();
    }

    public void changeFirstName(String firstName) {
        valueObject = new UserValueObject(firstName, valueObject.GetLastName());
    }

    public void changeLastName(String lastName) {
        valueObject = new UserValueObject(valueObject.GetFirstName(), lastName);
    }

    public String getLastName() {
        return valueObject.GetLastName();
    }

    public String getFirstName() {
        return valueObject.GetFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof User user)){
            return false;
        }
        return valueObject.equals(user.valueObject);
    }

    @Override
    public int hashCode() {
        return valueObject.hashCode();
    }
}
