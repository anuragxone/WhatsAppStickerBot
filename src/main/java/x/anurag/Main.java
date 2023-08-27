package x.anurag;

import it.auties.whatsapp.api.QrHandler;
import it.auties.whatsapp.api.Whatsapp;

public class Main {
    public static void main(String[] args) {
        Whatsapp.webBuilder()
                .newConnection()
                .unregistered(QrHandler.toTerminal())
                .addLoggedInListener(() -> System.out.println("Connected!"))
                .connect()
                .join();

    }
}