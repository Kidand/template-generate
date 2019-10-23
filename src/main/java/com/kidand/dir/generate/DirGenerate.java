package com.kidand.dir.generate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirGenerate {
    public static void main(String[] args) {
        CheckDir ch = new CheckDir();
        MkdirUtil m = new MkdirUtil();

        List<String> filePaths = new ArrayList<>();
        //等待替换变量map
        Map<String,String> map =new HashMap();
        filePaths = ch.getAllFilePaths( "C:\\Users\\Kidand\\Desktop\\${groupId}-cloud", filePaths,map);

        List l=new ArrayList();
        for ( String path : filePaths ) {
            for (String s : map.keySet()) {
                path=path.replace(s,map.get(s));
            }
            l.add(path);
        }
        for (Object o : l) {
            System.out.println( o );
        }

        m.generate(l);
    }
}
