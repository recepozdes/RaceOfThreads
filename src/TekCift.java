import java.util.ArrayList;

public class TekCift implements Runnable{
    private ArrayList<Integer> list;

    private final  Object LOCK= new Object();

    public TekCift(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public synchronized void run() {

        int i=0;
        while(i<list.size()){
            Integer num=this.list.get(i);

            if (num%2==0){
                Main.ciftSayilar.add(num);
            }else {
                Main.tekSayilar.add(num);
            }
            i++;
        }

    }
}
