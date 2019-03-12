package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 返回正的平方根。
 */
public class OperatorSqrt extends Operator {

    public OperatorSqrt(String name){
        this.name = name;
    }

    public OperatorSqrt(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        return Math.sqrt(((Number) list[0]).doubleValue());
    }

}
