package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 计算累加
 */
public class OperatorSum extends Operator {


    public OperatorSum(String name){
        this.name = name;
    }

    public OperatorSum(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        Object sum = list[0];
        for(int i=1; i < list.length; i++){
            sum =  OperatorOfNumber.add(sum, list[i],this.isPrecise);
        }
        return sum;
    }
}
