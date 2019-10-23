package com.kidand.dir.generate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckDir {

    static List<String> getAllFilePaths(String filePath, List<String> filePathList,Map map){
        File[] files = new File( filePath ).listFiles();


        HashMapUtil h = new HashMapUtil();

        if ( files == null ) {
            return filePathList;
        }
        for ( File file : files ) {
            if ( file.isDirectory() ) {//生成目录
                boolean status = file.getPath().contains("$");
                if(status){
                    String key = file.getPath().substring(file.getPath().lastIndexOf("${")+2,file.getPath().lastIndexOf("}"));
                    //放置变量
                    map.put("${"+key+"}",h.getValue(key));
                    getAllFilePaths( file.getAbsolutePath(), filePathList ,map);
                    filePathList.add(file.getPath());
                }else {
                    filePathList.add(file.getPath());
                    getAllFilePaths(file.getAbsolutePath(), filePathList,map);
                }
            } else {
                //生成相应文件
                //filePathList.add( file.getPath() );
            }
        }
        return filePathList;

    }

}
