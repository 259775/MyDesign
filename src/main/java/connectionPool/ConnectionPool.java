package connectionPool;

import domain.ConfigureField;
import domain.MyConnection;
import domain.MyException;

import java.util.ArrayList;

public class ConnectionPool {

    private static Integer connectionCount = ConfigureField.getConnectionCount();

    private static ArrayList<MyConnection> alm = new ArrayList<>();


    static {
        for (int i = 0; i < connectionCount; i++) {
            MyConnection myCon = new MyConnection();
            alm.add(myCon);
        }
    }

    public MyConnection getConnection() {
        Integer count = 0;
        MyConnection myCon = null;
        f:
        while (true) {
            for (int i = 0; i < alm.size(); i++) {
                if (alm.get(i).getState() == false) synchronized (alm.get(i)) {
                    if (alm.get(i).getState() == false) {
                        myCon = alm.get(i);
                        myCon.setState(true);
                        break f;
                    }
                }
            }
            if (myCon == null && count == 0) {
                try {
                    Thread.sleep(3000);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (myCon == null && count == 1) {
                return null;
            }
        }
        return myCon;
    }


}