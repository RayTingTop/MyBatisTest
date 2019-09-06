import org.junit.Test;
import java.io.*;

/**
 * @author RayTing
 * @date 2019-09-04 15:39
 */
public class IOTest {
    String path ="D:/test.txt";
    File file = new File(path);

    /**
     * 测试方法
     */
    @Test
    public void testFile(){
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        try {
            do {
                c = (char) br.read();
                System.out.println(c);
            } while (c != 'q');
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}