package Chatr.Domain.User;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void UserEntity_Equality(){
        // Given two User objects with the same id
        UUID id = UUID.randomUUID();
        User user1 = new User(id, "firstName", "lastName");
        User user2 = new User(id, "firstName", "lastName");

        // When the userEntities are compared
        boolean compare = user1.getId().equals(user2.getId());

        // Then they should be equal
        assertTrue(compare);
    }

    @Test
    public void UserEntity_ChangeId(){
        // Given a user with an empty id
        User user = new User(null, "firstName", "lastName");

        // When I change the id
        UUID newId = UUID.randomUUID();
        user.changeId(newId);

        // Then the id will match the new id
        assertEquals(user.getId(), newId);
    }

    @Test
    public void UserEntity_NullId(){
        // Given a user with an empty id
        User user = new User(null, "firstName", "lastName");

        // When we check if they match an empty id
        UUID emptyId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        boolean match = user.getId().equals(emptyId);

        // Then the id will match the empty id
        assertTrue(match);
    }

    @Test
    public void UserValueObject_Equality(){
        // Given a pair of users with the same names
        User user = new User(null, "firstName", "lastName");
        User user2 = new User(null, "firstName", "lastName");

        // When I check if the ValueObjects match
        boolean match = user.equals(user2);

        // Then I should get True
        assertTrue(match);
    }

    @Test
    public void UserValueObject_Equality_False(){
        // Given two pair of users with the same names
        User user = new User(null, "firstName", "lastName");
        User user2 = new User(null, "differentName", "lastName");
        User user3 = new User(null, "firstName", "lastName");
        User user4 = new User(null, "firstName", "differentName");

        // When I check if the ValueObjects match
        boolean match = user.equals(user2);
        boolean match2 = user3.equals(user4);

        // Then I should get True
        assertFalse(match);
        assertFalse(match2);
    }

    @Test
    public void UserValueObject_Equality_False_NotUser(){
        // Given a user and another object
        User user = new User(null, "firstName", "lastName");
        Object object = new Object();


        // When I check if the ValueObjects match
        boolean match = user.equals(object);

        // Then I should get True
        assertFalse(match);
    }

    @Test
    public void UserValueObject_ChangeNames(){
        // Given a user with names
        User user = new User(UUID.randomUUID(), "original", "original");

        // When I change the names
        String firstName = "Bob";
        String lastName = "Smith";
        user.changeFirstName(firstName);
        user.changeLastName(lastName);

        // Then the ValueObjects names should match the inputted names
        assertEquals(user.getFirstName(), firstName);
        assertEquals(user.getLastName(), lastName);
    }

    @Test
    public void User_HashCheck(){
        // Given two users with the same details
        User user = new User(UUID.randomUUID(), "original", "original");
        User user2 = new User(UUID.randomUUID(), "original", "original");

        // When I check if the hashCodes are the same
        boolean check = user.hashCode() == user2.hashCode();

        // Then it should be true
        assertTrue(check);
    }
}