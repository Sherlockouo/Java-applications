package img;

public class Test {
	 
	 
    public static void main(String[] args)  {
             
            //����ֻ�ܿ������̣߳����˾ͱ�502��
            Download download1 = new Download();
            Download download2 = new Download();
            Download download3 = new Download();
             
            download1.start();
            download2.start();
            download3.start();
    }

}