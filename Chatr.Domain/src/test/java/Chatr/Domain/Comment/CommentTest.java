package Chatr.Domain.Comment;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    public void CommentEntity_Equality() {
        // Given two comments with the same id
        UUID id = UUID.randomUUID();
        Comment comment1 = new Comment(id, "test", new Date());
        Comment comment2 = new Comment(id, "test", new Date());

        // When I check for equality between the entities
        boolean check = comment1.getId().equals(comment2.getId());

        // Then it should be true
        assertTrue(check);
    }

    @Test
    public void CommentEntity_ChangeId() {
        // Given a comment with an id
        UUID id = UUID.randomUUID();
        Comment comment = new Comment(id, "test", new Date());

        // When I change the id
        UUID newId = UUID.randomUUID();
        comment.changeId(newId);

        // Then the comment should have the new id
        assertEquals(comment.getId(), newId);
    }

    @Test
    public void CommentEntity_NullId() {
        // Given a comment without an id
        Comment comment = new Comment(null, "Test", new Date());

        // When I check to see if an empty guid matches
        UUID emptyId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        boolean match = comment.getId().equals(emptyId);

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void CommentValueObject_Equality() {
        // Given two comments with identical content and dates
        Date now = new Date();
        Comment comment = new Comment(null, "Hello world!" , now);
        Comment comment2 = new Comment(null, "Hello world!" , now);

        // When I check if the ValueObjects are equal
        boolean match = comment.equals(comment2);

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void CommentValueObject_Equality_False() {
        // Given two comments with different content and dates
        Date now = new Date();
        Comment comment = new Comment(null, "Hello world!" , now);
        Comment comment2 = new Comment(null, "Hi Bob!" , new Date(2000));

        // When I check if the ValueObjects are equal
        boolean match = comment.equals(comment2);

        // Then it should be false
        assertFalse(match);
    }

    @Test
    public void CommentValueObject_Equality_False_NotComment() {
        // Given a comment and another object
        Comment comment = new Comment(null, "Hello world!" , new Date());
        Object object = new Object();

        // When I check if the objects are equal
        boolean match = comment.equals(object);

        // Then it should be false
        assertFalse(match);
    }

    @Test
    public void CommentValueObject_CheckHash() {
        // Given two comments with identical content and dates
        Date now = new Date();
        Comment comment = new Comment(null, "Hello world!" , now);
        Comment comment2 = new Comment(null, "Hello world!" , now);

        // When I check if the ValueObject hashes are equal
        boolean match = comment.hashCode() == comment2.hashCode();

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void CommentValueObject_ChangeContent() {
        // Given a comment object
        Comment comment = new Comment(null, "Hello world!" , new Date());

        // When I change the content
        String newContent = "new stuff!";
        comment.changeContent(newContent);

        // Then the content in the comment should match the new content
        assertEquals(comment.getContent(), newContent);
    }

    @Test
    public void CommentValueObject_ChangeDate() {
        // Given a comment object
        Date oldDate = new Date();
        Comment comment = new Comment(null, "Hello world!" , oldDate);

        // When I change the date
        Date newDate = new Date(2000);
        comment.changeDate(newDate);

        // Then the date in the comment should match the new date
        assertEquals(comment.getDate(), newDate);
        assertNotEquals(comment.getDate(), oldDate);
    }

}