package com.ycx.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ycx.entities.CommonResult;
import com.ycx.entities.Payment;

public class CustomBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException---1", null);
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "按客户自定义，global handlerException---2", null);
    }
}
