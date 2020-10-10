import edu.duke.*;
import java.io.File;

public class BatchGrayScale {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    public void selectAndConvert() {
        DirectoryResource dirResource = new DirectoryResource();
        for (File file: dirResource.selectedFiles()) {
            ImageResource inImage = new ImageResource(file);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }
    public void graySave() {
        DirectoryResource dirResource = new DirectoryResource();
        for (File file: dirResource.selectedFiles()) {
            ImageResource image = new ImageResource(file);
            ImageResource greyImage = makeGray(image);
            String fileName = image.getFileName();
            String newFileName = "grey-" + fileName;
            greyImage.setFileName(newFileName);
            greyImage.draw();
            greyImage.save();
        }
    }
    public static void main(String[] args) {
        BatchGrayScale obj = new BatchGrayScale();
        //obj.testGray();
        obj.graySave();
    }
}