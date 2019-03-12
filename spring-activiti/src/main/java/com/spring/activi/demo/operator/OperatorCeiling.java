package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 返回将参数 number 向上舍入（沿绝对值增大的方向）为最接近的指定基数的倍数。
 */
public class OperatorCeiling extends Operator {

    public OperatorCeiling(String name){
        this.name = name;
    }

    public OperatorCeiling(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        return executeInner(list[0], list[1]);
    }

    public Object executeInner(Object object1, Object object2) throws Exception {
        Integer object = (Integer) object1;
        Object result = OperatorOfNumber.modulo(object1, object2);


        return object1;
    }
}
