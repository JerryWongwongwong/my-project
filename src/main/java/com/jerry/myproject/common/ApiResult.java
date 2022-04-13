package com.jerry.myproject.common;

import com.jerry.myproject.enums.ResultCode;
import lombok.Data;

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
@Data
public class ApiResult {


    /**
     * 结果码
     */
    private String code;

    /**
     * 结果码描述
     */
    private String msg;


    public ApiResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 生成一个ApiResult对象, 并返回
     *
     * @param resultCode
     * @return
     */
    public static ApiResult of(ResultCode resultCode) {
        return new ApiResult(resultCode);
    }
}
