package designpattern.decorator.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author wangdongxing
 * @since 2018/11/14 9:13 AM
 */
public class InputTestMain {

    public static void main(String[] args) {
        int c;
        try {
            File directory = new File("");
            System.out.println(directory.getCanonicalPath());
            System.out.println(directory.getAbsolutePath());
            InputStream inputStream = new LowerCaseInputStream(
                    new BufferedInputStream(new FileInputStream("src/main/java/designpattern/decorator/io/test.txt")));
            while ((c = inputStream.read()) > 0) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
