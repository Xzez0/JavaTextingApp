import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Message {
    private String sender;
    private String content;
    private String receiver;

    public Message(String sender, String content, String receiver) {
        this.sender = sender;
        this.content = content;
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getReceiver() {
        return receiver;
    }
}

class MessagingApp {
    private List<Message> messages = new ArrayList<>();

    public void sendMessage(String sender, String content, String receiver) {
        Message message = new Message(sender, content, receiver);
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}

public class App {
    public static void main(String[] args) {
        MessagingApp app = new MessagingApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Messaging App!");

        while (true) {
            System.out.print("Enter your name (or 'exit' to quit): ");
            String sender = scanner.nextLine();

            if (sender.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("To Who?: ");
            String receiver1 = scanner.nextLine();

            System.out.print("Enter your message: ");
            String message = scanner.nextLine();

            app.sendMessage(sender, message, receiver1);
        }

        List<Message> messages = app.getMessages();
        System.out.println("\n--- Chat History ---");
        for (Message msg : messages) {
            System.out.println(msg.getSender() + " To " + msg.getReceiver() + ": " + msg.getContent());
        }
    }
}
