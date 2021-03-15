package util;

import java.util.HashMap;

public class ThreadLocalManager {
    private static HashMap<String,ThreadLocal> localMap = new HashMap<>();

    public static ThreadLocal getThreadLocal(String localKey){
        ThreadLocal result = localMap.get(localKey);
        if(result == null){
            result = new ThreadLocal();
            localMap.put(localKey,result);
        }
        return result;
    }

    public static void setlocal(String key,ThreadLocal local){
        localMap.put(key,local);
    }
}
