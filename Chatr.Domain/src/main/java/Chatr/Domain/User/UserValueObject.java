package Chatr.Domain.User;

import java.util.Objects;

public class UserValueObject {
    private String firstName;
    private String lastName;

    protected UserValueObject(String firstName, String lastName ){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserValueObject that)) return false;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    protected String GetLastName(){
        return lastName;
    }

    protected String GetFirstName(){
        return firstName;
    }
}
