package img;

public class Test {
	 
	 
    public static void main(String[] args)  {
             
            //好像只能开三个线程，多了就报502了
            Download download1 = new Download();
            Download download2 = new Download();
            Download download3 = new Download();
             
            download1.start();
            download2.start();
            download3.start();
    }

}