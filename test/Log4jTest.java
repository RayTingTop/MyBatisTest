import org.apache.log4j.Logger;

/**
 * @author RayTing
 * @date 2019-09-09 16:28
 */
public class Log4jTest{
    public static Logger log=Logger.getLogger(Log4jTest.class);
    public static void main(String[] args){
        log.debug("debug信息");
        log.info("info信息");
    }
}
