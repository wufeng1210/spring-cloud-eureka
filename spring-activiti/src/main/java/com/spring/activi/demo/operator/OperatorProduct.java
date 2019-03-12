package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 函数使所有以参数形式给出的数字相乘并返回乘积。
 */
public class OperatorProduct extends Operator {

    public OperatorProduct(String name){
        this.name = name;
    }

    public OperatorProduct(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        Object sum = list[0];
        for(int i=1; i < list.length; i++){
            sum =  OperatorOfNumber.multiply(sum, list[i],this.isPrecise);
        }
        return sum;
    }

}
