public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        this.messageID = createMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random 10-digit message ID
    public String createMessageID() {

        long number = (long) (Math.random() * 1000000000L);

        return String.format("%010d", number);
    }

    // Check recipient cell number
    public boolean checkRecipientCell(String number) {

        return number.matches("^\\+27\\d{9}$");
    }

    // Check message length
    public boolean checkMessageLength(String text) {

        return text.length() <= 250;
    }

    // Create message hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    // Print message details
    public String printMessage() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    // Getters
    public String getMessageID() {
        return messageID;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getMessageHash() {
        return messageHash;
    }
}
