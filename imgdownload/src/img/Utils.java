package img;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class Utils {
         
        //��¼����
        public static int day = 0;
         
        //���ͼƬ����Ϊ��ҳ����������Ϊ�ļ���
        public static String getName(int day) {
                 
                //��õ�ǰʱ���������
                Calendar calendar = Calendar.getInstance();
                 
                //���ݴ�����������������ͼƬ�����ʱ��
                calendar.add(Calendar.DAY_OF_MONTH, -day);
                 
                //���ݵ��������������ʱ��
                Date date = calendar.getTime();
                 
                //�������ǵ�ʱ������
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String fileName = sdf.format(date);
                return fileName;
        }
}
