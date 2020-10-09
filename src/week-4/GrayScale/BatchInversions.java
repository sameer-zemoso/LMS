import edu.duke.*;
import java.io.File;

public class BatchInversions {

    public ImageResource makeInversion(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for(Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getGreen());
            pixel.setBlue(255 - inPixel.getBlue());
        }
        return outImage;
    }
    public void testmakeInversion() {
        ImageResource originalImage = new ImageResource();
        ImageResource invertedImage = makeInversion(originalImage);
        invertedImage.draw();
    }
    public void selectAndConvert() {
        DirectoryResource dirResource = new DirectoryResource();
        for (File file: dirResource.selectedFiles()) {
            ImageResource inImage = new ImageResource(file);
            ImageResource outImage = makeInversion(inImage);
            String fileName = inImage.getFileName();
            String newFileName = "inverted-" + fileName;
            outImage.setFileName(newFileName);
            outImage.save();
            outImage.draw();
        }
    }
    public static void main(String[] args) {
        BatchInversions obj = new BatchInversions();
        //obj.testmakeInversion();
        obj.selectAndConvert();
    }
}