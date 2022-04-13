package com.jerry.myproject.common;

import com.jerry.myproject.enums.ResultCode;

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
public class BusinessRuntimeException extends RuntimeException {


    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;

    /**
     * 结果码枚举
     */
    private ResultCode resultCode;


    public BusinessRuntimeException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.resultCode = resultCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }


}
