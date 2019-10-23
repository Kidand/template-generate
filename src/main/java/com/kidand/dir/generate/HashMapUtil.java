package com.kidand.dir.generate;
import java.util.HashMap;

public class HashMapUtil {
    public String getValue(String key){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("groupId","kidand");
        hashMap.put("basepackage_dir","com");
        return hashMap.get(key);
    }
}
