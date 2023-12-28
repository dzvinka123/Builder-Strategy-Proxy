package ucu.edu.ua.proxy;
import lombok.Getter;


@Getter
public class ProxyImage implements MyImage {
    private String filename;
    private RealImage image = null;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void displayPhoto(){
        if (image == null){
            image = new RealImage(filename);
        }
        image.displayPhoto();
    }


}