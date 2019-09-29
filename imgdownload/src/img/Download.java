package img;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Download extends Thread{
         
        public void run() {
                 
                while(true){
                 
                        int day ;
                        //�����������ݣ���Ҫ���м���
                        synchronized (Class.class) {
                                day = Utils.day++;
                        }
                        //����30���ڵ�ͼƬ�����ֿ��Ե��������¶��پ��¶��٣����������޶ȾͿ���
                        if(day > 120) {
                                break;
                        }
                 
                        String u = "https://bing.ioliu.cn/v1?d="+ day +"&w=1920&h=1080";
                        URL url;
                         
                        try {
                                url = new URL(u);
                                DataInputStream dis = new DataInputStream(url.openStream());
                                 
                                File f = new File("F:\\biying\\");
                                 
                                //·�������ڻ��߲����ļ���,�ʹ���һ��
                                if(!f.exists() || f.isFile()) {
                                        f.mkdir();
                                }
                                 
                                //������������ļ���
                                String fileName = Utils.getName(day);
                                File file = new File("F:\\biying\\"+fileName+".jpg");
                                //Ϊ�˱����ظ����أ�������Ҫ�жϡ������ж�һ��·�����ɣ�����ʵ�ʷ�����Щ������102�ֽ�
                                //����200�ֽڣ��������Σ�������һ��ѭ��
                                if(file.exists() || file.length() > 200) {
                                        continue;
                                }
                                FileOutputStream fos = new FileOutputStream(file);
                                 
                                byte[] bs = new byte[8192];
                                int len;
                                 
                                while ((len = dis.read(bs)) != -1) {
                                        fos.write(bs, 0, len);
                                }
                                fos.close();
                                dis.close();
                                 
                        } catch (MalformedURLException e) {
                                e.printStackTrace();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
 
}