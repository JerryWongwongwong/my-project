package com.jerry.myproject;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.jerry.myproject.server.impl.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/11/15 21:53
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExclTest {


    @Autowired
    private CacheService cacheService;

    @Test
    public void test1() {

        for (int i = 0; i < 50000; i++) {

//            try {
//                Thread.sleep(8000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            int num = cacheService.getNum();
            System.out.println("得到结果：" + num);
        }


    }

    @Test
    public void test() throws FileNotFoundException {

        // 生成EXCEL并指定输出路径
        OutputStream out = new FileOutputStream("/Users/jerry/Desktop/1109-1.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        // 设置SHEET
        Sheet sheet = new Sheet(1, 0);
        sheet.setSheetName("sheet1");

        // 设置标题
        Table table = new Table(1);
        List<List<String>> titles = new ArrayList<List<String>>();
        titles.add(Arrays.asList("第1列"));
        titles.add(Arrays.asList("第2列"));
        titles.add(Arrays.asList("第3列"));
        titles.add(Arrays.asList("第4列"));
//        titles.add(Arrays.asList("第5列"));
//        titles.add(Arrays.asList("第6列"));
//        titles.add(Arrays.asList("第7列"));
//        titles.add(Arrays.asList("第8列"));
//        titles.add(Arrays.asList("第9列"));
//        titles.add(Arrays.asList("第10列"));
        table.setHead(titles);

        // 查询数据导出即可 比如说一次性总共查询出100条数据
        List<List<String>> userList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            userList.add(Arrays.asList("ID_" + i, "小明" + i, String.valueOf(i), new Date().toString()));
        }

        writer.write0(userList, sheet, table);
        writer.finish();

    }
}
