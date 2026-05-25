import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    // Test valid recipient number
    @Test
    public void testCheckRecipientCell_Valid() {

        Message msg = new Message(0, "+27838968976", "Hello");

        assertTrue(msg.checkRecipientCell("+27838968976"));
    }

    // Test invalid recipient number
    @Test
    public void testCheckRecipientCell_Invalid() {

        Message msg = new Message(0, "0838968976", "Hello");

        assertFalse(msg.checkRecipientCell("0838968976"));
    }

    // Test valid message length
    @Test
    public void testCheckMessageLength_Valid() {

        Message msg = new Message(0, "+27838968976", "Short message");

        assertTrue(msg.checkMessageLength("Short message"));
    }

    // Test invalid message length
    @Test
    public void testCheckMessageLength_Invalid() {

        String longMessage = "a".repeat(300);

        Message msg = new Message(0, "+27838968976", longMessage);

        assertFalse(msg.checkMessageLength(longMessage));
    }

    // Test message ID length
    @Test
    public void testCreateMessageID() {

        Message msg = new Message(0, "+27838968976", "Hello");

        assertEquals(10, msg.getMessageID().length());
    }

    // Test message hash
    @Test
    public void testCreateMessageHash() {

        Message msg = new Message(0, "+27838968976", "Hi there");

        String hash = msg.getMessageHash();

        assertTrue(hash.contains("HITHERE"));
    }
}
