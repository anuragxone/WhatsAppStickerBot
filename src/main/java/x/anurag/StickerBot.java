package x.anurag;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.info.MessageInfo;

import java.nio.file.FileSystems;
import java.nio.file.Path;


public class StickerBot {
    public static void main(String[] args) {
        Whatsapp.webBuilder()
                .lastConnection()
                .registered().get()
                .addLoggedInListener(() -> System.out.println("Connected!"))
                .addNewMessageListener(StickerBot::onMessage)
                .connect()
                .join();

    }

    private static void onMessage(Whatsapp api, MessageInfo info){
        var imageMessage = info
                .message()
                .imageMessage()
                .get();
        Path path = FileSystems.getDefault().getPath(".", "downloadedImages", "image.jpg");

        imageMessage.save(path);


    }


}
