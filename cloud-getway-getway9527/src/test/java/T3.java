import java.time.ZonedDateTime;

public class T3 {
    public static void main(String[] args) {
        ZonedDateTime zdj = ZonedDateTime.now();    //默认时区
        System.out.println(zdj);
//        2020-04-20T09:22:42.100+08:00[Asia/Shanghai]
    }
}
