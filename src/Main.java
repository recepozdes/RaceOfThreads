import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> tekSayilar=new ArrayList<>();
    public static ArrayList<Integer> ciftSayilar=new ArrayList<>();

    public static void main(String[] args) {
	// write your code here

        ArrayList<Integer> mainList=new ArrayList<>();

        int totalNum=10000;
        int division=4;
        int intervalLength= totalNum/division;

        for(int i=1;i<=totalNum;i++){
            mainList.add(i);
        }

        ArrayList<ArrayList<Integer>> sublist2=new ArrayList<>();

        for (int i=0;i<division;i++){
            ArrayList<Integer> sublist=new ArrayList<>();

            for(int j=i*intervalLength;j<(i+1)*intervalLength;j++){
                sublist.add(mainList.get(j));
            }
            sublist2.add(sublist);
        }

        TekCift tekCift1=new TekCift(sublist2.get(0));
        Thread t1=new Thread (tekCift1);
        t1.start();


        TekCift tekCift2=new TekCift(sublist2.get(1));
        Thread t2=new Thread (tekCift2);
        t2.start();


        TekCift tekCift3=new TekCift(sublist2.get(2));
        Thread t3=new Thread (tekCift3);
        t3.start();


        TekCift tekCift4=new TekCift(sublist2.get(3));
        Thread t4=new Thread (tekCift4);
        t4.start();


        do{
            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while (t1.isAlive()|| t2.isAlive()||t3.isAlive()|| t4.isAlive());

        System.out.println(tekSayilar);
        System.out.println(ciftSayilar);
    }
}
