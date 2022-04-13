package com.jerry.myproject.enums;

/**
 * CopyRight : 杭州大掌柜物流科技有限公司
 * Project :  zouwu-oms-order
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2021-10-27 11:01
 *
 * @author : Jerry
 * @version : 0.1.0
 * @since : 0.1.0
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS("0", "success"),

    /**
     * 未知错误
     */
    UNKNOWN_ERROR("0x10001", "unkonwn error"),

    /**
     * 用户名错误或不存在
     */
    USERNAME_ERROR("0x10002", "username error or does not exist"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR("0x10003", "password error"),

    /**
     * 用户名不能为空
     */
    USERNAME_EMPTY("0x10004", "username can not be empty");

    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;


    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
