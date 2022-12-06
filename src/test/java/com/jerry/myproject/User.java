package com.jerry.myproject;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CopyRight (c)2018-2022 : cargogm.com
 * Project :  my-project
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022/12/05 10:57
 *
 * @author : Jerry
 * @version : 1.0
 * @since : 1.0
 */
@Data
@AllArgsConstructor
public class User {

    private String uid;
    private String name;
}
