package img;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class Utils {
         
        //记录天数
        public static int day = 0;
         
        //获得图片的作为首页的年月日作为文件名
        public static String getName(int day) {
                 
                //获得当前时间的万年历
                Calendar calendar = Calendar.getInstance();
                 
                //根据传进来的天数调整成图片当天的时间
                calendar.add(Calendar.DAY_OF_MONTH, -day);
                 
                //根据调整的万年历获得时间
                Date date = calendar.getTime();
                 
                //按照我们的时间格调整
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String fileName = sdf.format(date);
                return fileName;
        }
}
