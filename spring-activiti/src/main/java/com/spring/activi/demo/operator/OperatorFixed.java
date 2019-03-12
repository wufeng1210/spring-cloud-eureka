package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;
import com.spring.activi.demo.util.Arith;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption:  将数字舍入到指定的小数位数，以十进制数格式对该数进行格式设置，并以文本形式返回结果。
 */
public class OperatorFixed extends Operator {


    public OperatorFixed(String name){
        this.name = name;
    }

    public OperatorFixed(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        return Arith.round(((Number) list[0]).doubleValue(), ((Number) list[1]).intValue());
    }
}
