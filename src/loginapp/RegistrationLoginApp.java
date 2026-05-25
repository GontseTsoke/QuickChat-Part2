import java.util.Scanner;

public class RegistrationLoginApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        WELCOME TO QUICKCHAT");
        System.out.println("=================================");

        // Ask user for number of messages
        System.out.print("How many messages would you like to send? ");
        int totalMessages = input.nextInt();
        input.nextLine();

        int sentMessages = 0;

        // Arrays to store messages
        String[] sentMessageHashes = new String[totalMessages];
        String[] sentRecipients = new String[totalMessages];
        String[] sentMessagesText = new String[totalMessages];

        while (true) {

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                // SEND MESSAGE
                case 1:

                    if (sentMessages >= totalMessages) {

                        System.out.println("Message limit reached.");
                        break;
                    }

                    // Enter recipient
                    System.out.print("Enter recipient number (+27...): ");
                    String recipient = input.nextLine();

                    // Enter message
                    System.out.print("Enter your message: ");
                    String text = input.nextLine();

                    // Create message object
                    Message msg = new Message(sentMessages, recipient, text);

                    // Validate recipient
                    if (!msg.checkRecipientCell(recipient)) {

                        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                        break;
                    }

                    // Validate message length
                    if (!msg.checkMessageLength(text)) {

                        System.out.println("Message exceeds 250 characters by "
                                + (text.length() - 250)
                                + " characters, please reduce size.");

                        break;
                    }

                    // Message options
                    System.out.println("\nChoose an option:");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");

                    System.out.print("Enter option: ");
                    int option = input.nextInt();
                    input.nextLine();

                    // SEND MESSAGE
                    if (option == 1) {

                        System.out.println("\nMessage successfully sent.");
                        System.out.println("---------------------------------");
                        System.out.println(msg.printMessage());
                        System.out.println("---------------------------------");

                        // Store messages in arrays
                        sentMessageHashes[sentMessages] = msg.getMessageHash();
                        sentRecipients[sentMessages] = msg.getRecipient();
                        sentMessagesText[sentMessages] = msg.getMessageText();

                        sentMessages++;

                    }
                    // DISCARD MESSAGE
                    else if (option == 2) {

                        System.out.println("Message discarded.");

                    }
                    // STORE MESSAGE
                    else if (option == 3) {

                        System.out.println("Message successfully stored.");

                    } else {

                        System.out.println("Invalid option.");
                    }

                    break;

                // SHOW SENT MESSAGES
                case 2:

                    if (sentMessages == 0) {

                        System.out.println("No messages sent yet.");

                    } else {

                        System.out.println("\n========== SENT MESSAGES ==========");

                        for (int i = 0; i < sentMessages; i++) {

                            System.out.println("---------------------------------");
                            System.out.println("Recipient: " + sentRecipients[i]);
                            System.out.println("Message: " + sentMessagesText[i]);
                            System.out.println("Hash: " + sentMessageHashes[i]);
                        }

                        System.out.println("---------------------------------");
                        System.out.println("Total messages sent: " + sentMessages);
                    }

                    break;

                // QUIT
                case 3:

                    System.out.println("Thank you for using QuickChat.");
                    System.out.println("Goodbye.");
                    return;

                // INVALID OPTION
                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}