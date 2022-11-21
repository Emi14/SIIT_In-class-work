package org.siit.week2;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 1. Implement a method which receives the file system path to an image,
 * loads the image, rotates it 90 degrees right and saves
 * the new image in the same folder as the original one,
 * but with a slightly different name.
 * <p>
 * 2. a) Download scalar source code: https://github.com/rkalla/imgscalr
 * b) Compile it: javac org/imgscalr/Scalr.java
 * c) Create a jar: jar cf scalar.jar org/imgscalr/*.class
 * d) Add the created jar as library in intellij: File -> Project Structure -> Libraries -> +
 * N.B. :For compiling you should use the same JDK version that you are going to use for running the program (e.g. 1.8)
 */
public class ImageProcessor {

    private static BufferedImage rotateImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int type = image.getType();
        BufferedImage newImage = new BufferedImage(width, height, type);

        Graphics2D graphics2D = newImage.createGraphics();
        graphics2D.rotate(Math.toRadians(90), width / 2, height / 2);
        graphics2D.drawImage(image, null, 0, 0);
        return newImage;
    }

    public void execute() throws IOException {
        BufferedImage image = readImage("src/main/resources/poza.jpg");

        BufferedImage newImage = rotateImage(image);

        ImageIO.write(newImage, "jpg", new File("src/main/resources/poza2.jpg"));
    }

    public void executeWithLibrary() throws IOException {
        BufferedImage image = readImage("src/main/resources/poza.jpg");

        BufferedImage newImage = Scalr.rotate(image, Scalr.Rotation.CW_90);

        ImageIO.write(newImage, "jpg", new File("src/main/resources/poza3.jpg"));
    }

    public BufferedImage readImage(String pathname) throws IOException {
        File sourceFile = new File(pathname);
        return ImageIO.read(sourceFile);
    }

}
