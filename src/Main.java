import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Q q=new Q();
        proceed p1=new proceed(q);
        check c1=new check(q);
        c1.start();
        p1.start();

    }
    
}

class Q{
    boolean q;

    synchronized  boolean isQ() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return q;
    }

    synchronized  void setQ(boolean q) {
        this.q = q;
        notify();
    }
}

class check extends Thread {
    frontpage f1;
    Q q;
//    Thread t;
    check(Q q){
        this.q=q;
//        t=new Thread(this);

    }

    @Override
    public void run() {

        f1=new frontpage();
        if(f1.fill()){
            q.setQ(true);
            f1.firstframe.setVisible(false);

        }
    }


}

class proceed extends Thread {
    gymmember g1;
    Q q;
//    Thread t;
    proceed(Q q){
        this.q=q;
//        t=new Thread(this);
    }
    @Override
    public void run() {
        try {
            g1=new gymmember();
        } catch (IOException e) {
            e.printStackTrace();
        }
        q.isQ();
        g1.loginframe.setVisible(true);

    }

}
