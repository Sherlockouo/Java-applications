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
                        //操作公共数据，需要进行加锁
                        synchronized (Class.class) {
                                day = Utils.day++;
                        }
                        //下载30天内的图片，数字可以调整，想下多少就下多少，不超过他限度就可以
                        if(day > 120) {
                                break;
                        }
                 
                        String u = "https://bing.ioliu.cn/v1?d="+ day +"&w=1920&h=1080";
                        URL url;
                         
                        try {
                                url = new URL(u);
                                DataInputStream dis = new DataInputStream(url.openStream());
                                 
                                File f = new File("F:\\biying\\");
                                 
                                //路径不存在或者不是文件夹,就创建一个
                                if(!f.exists() || f.isFile()) {
                                        f.mkdir();
                                }
                                 
                                //根据天数获得文件名
                                String fileName = Utils.getName(day);
                                File file = new File("F:\\biying\\"+fileName+".jpg");
                                //为了避免重复下载，所以需要判断。本来判断一下路径即可，但是实际发现有些下载了102字节
                                //超过200字节，跳过本次，继续下一次循环
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