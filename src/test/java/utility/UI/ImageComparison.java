package utility.UI;

import pages.CommonPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static stepDefinitions.Hooks.driver;

public class ImageComparison extends CommonPage {
    public static BufferedImage image1;
    public static BufferedImage image2;
    public static String filePath;


    public static void beforeScreenShot(){
        Screenshot screenshotOnPage = new AShot().shootingStrategy(
                ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        image1 = screenshotOnPage.getImage();
        filePath= "src/test/resources/Images";
        try {
            ImageIO.write(image1, "PNG", new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void afterScreenShot(){
        Screenshot screenshotOnPage = new AShot().shootingStrategy(
                ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
       image2 = screenshotOnPage.getImage();
        String filePath= "src/test/resources/Images";
        try {
            ImageIO.write(image2, "PNG", new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void verifyScreenShot(){
        ImageDiffer imgDiff = new ImageDiffer();

        ImageDiff diff = imgDiff.makeDiff(image1,image2);



        BufferedImage diffImage = diff.getDiffImage();
        try {
            ImageIO.write(diffImage, "PNG", new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n diffImage= "+diffImage.getColorModel() );




    }


}