package ucu.edu.ua.proxy;

import lombok.Builder;
import lombok.Getter;


@Builder @Getter
public class ProxyImage implements MyImage {
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayPhoto() {
       RealImage image = new RealImage(filename);
        image.displayPhoto();
    }


}
