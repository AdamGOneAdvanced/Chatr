package Chatr.Domain.Post;

import Chatr.Domain.Comment.Comment;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    public void postEntity_Equality() {
        // Given two posts with the same id
        UUID id = UUID.randomUUID();
        Post post1 = new Post(id, "test", new Date());
        Post post2 = new Post(id, "test", new Date());

        // When I check for equality between the entities
        boolean check = post1.getId().equals(post2.getId());

        // Then it should be true
        assertTrue(check);
    }

    @Test
    public void postEntity_ChangeId() {
        // Given a post with an id
        UUID id = UUID.randomUUID();
        Post post = new Post(id, "test", new Date());

        // When I change the id
        UUID newId = UUID.randomUUID();
        post.changeId(newId);

        // Then the post should have the new id
        assertEquals(post.getId(), newId);
    }

    @Test
    public void postEntity_NullId() {
        // Given a post without an id
        Post post = new Post(null, "Test", new Date());

        // When I check to see if an empty guid matches
        UUID emptyId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        boolean match = post.getId().equals(emptyId);

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void postValueObject_Equality() {
        // Given two posts with identical content and dates
        Date now = new Date();
        Post post = new Post(null, "Hello world!" , now);
        Post post2 = new Post(null, "Hello world!" , now);

        // When I check if the ValueObjects are equal
        boolean match = post.equals(post2);

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void postValueObject_Equality_False() {
        // Given two posts with different content and dates
        Date now = new Date();
        Post post = new Post(null, "Hello world!" , now);
        Post post2 = new Post(null, "Hi Bob!" , new Date(2000));

        // When I check if the ValueObjects are equal
        boolean match = post.equals(post2);

        // Then it should be false
        assertFalse(match);
    }

    @Test
    public void postValueObject_Equality_False_NotPost() {
        // Given a post and another object
        Post post = new Post(null, "Hello world!" , new Date());
        Object object = new Object();

        // When I check if the objects are equal
        boolean match = post.equals(object);

        // Then it should be false
        assertFalse(match);
    }

    @Test
    public void postValueObject_CheckHash() {
        // Given two posts with identical content and dates
        Date now = new Date();
        Post post = new Post(null, "Hello world!" , now);
        Post post2 = new Post(null, "Hello world!" , now);

        // When I check if the ValueObject hashes are equal
        boolean match = post.hashCode() == post2.hashCode();

        // Then it should be true
        assertTrue(match);
    }

    @Test
    public void postValueObject_ChangeContent() {
        // Given a post object
        Post post = new Post(null, "Hello World!", new Date());

        // When I change the content
        String newContent = "new stuff!";
        post.changeContent(newContent);

        // Then the content in the post should match the new content
        assertEquals(post.getContent(), newContent);
    }

    @Test
    public void postValueObject_ChangeDate() {
        // Given a post object
        Date oldDate = new Date();
        Post post = new Post(null, "Hello World!", oldDate);

        // When I change the date
        Date newDate = new Date(2000);
        post.changeDate(newDate);

        // Then the date in the post should match the new date
        assertEquals(post.getDate(), newDate);
        assertNotEquals(post.getDate(), oldDate);
    }

    @Test
    public void post_AddComment() {
        // Given a post and a comment
        Post post = new Post(null, "hi!", new Date());
        Comment comment = new Comment(null, "hi!", new Date());

        // When I add the comment to the post
        post.addComment(comment);

        // Then there should be a comment on the post
        assertTrue(post.getComments().size() == 1);
        assertTrue(post.getComments().contains(comment));
    }
}