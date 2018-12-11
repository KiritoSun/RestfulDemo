package com.zt.util;

import com.zt.common.Result;
import org.springframework.stereotype.Component;

/*
**  提供返回数据包的工具类
 */
@Component
public class ResultUtil {
    public Result SUCCESS(String msg,Object data){
        return new Result(0,msg,data);
    }

    public Result ERROR(String msg,Object data){
        return new Result(1,msg,data);
    }

    public Result CUSTOM(Integer code,String msg,Object data){
        return new Result(code,msg,data);
    }
}
