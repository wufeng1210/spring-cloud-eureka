package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 将数字向下舍入到最接近的整数。
 */
public class OperatorInt extends Operator {

    public OperatorInt(String name){
        this.name = name;
    }

    public OperatorInt(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        return executeInner(list[0]);
    }

    public Object executeInner(Object object1) throws Exception {
        Integer object = (Integer) object1;
        return object;
    }
}
