package com.kidand.dir.generate;

import cn.hutool.core.io.FileUtil;
import java.io.File;

import java.util.List;

/**
 * 创建目录或文件（空）
 */
public class MkdirUtil {
    public void generate(List l){
        FileUtil f = new FileUtil();
        System.out.println("开始创建");
        for(Object o : l){
            boolean status = o.toString().contains(".");
            if(!status){
                f.mkdir((String) o);
            }else{
                f.touch((String) o);
            }

        }
        System.out.println("创建成功！");
    }
}
