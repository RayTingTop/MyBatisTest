import org.junit.Test;

import java.io.*;

/**
 * @author RayTing
 * @date 2019-09-04 15:39
 */
public class IOTest {
    String path ="D:/test.txt";
    File file = new File(path);
    @Test
    /**
     * 测试方法
     */
    public void testFile(){
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            System.out.println("file.exists() = " + file.exists());

            FileOutputStream os = new FileOutputStream(file);

            FileInputStream is = new FileInputStream(file);
            byte[] bytes = new byte[]{};
            is.read(bytes);

            System.out.println("bytes.length = " + bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                System.out.print(bytes[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试方法
     */
    @Test
    public  void testBufferedReader(){
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String test = null;
//        try {
//            test = reader.readLine();//从键盘读取
//            System.out.println("test = " + test);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader(file));
            System.out.println("reader1.readLine() = " + reader1.readLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}