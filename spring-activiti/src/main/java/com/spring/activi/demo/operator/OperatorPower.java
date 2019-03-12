package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 返回数字乘幂的结果。
 */
public class OperatorPower extends Operator {

    public OperatorPower(String name){
        this.name = name;
    }

    public OperatorPower(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }


    @Override
    public Object executeInner(Object[] list) throws Exception {
      return Math.pow(((Number) list[0]).doubleValue(), ((Number) list[1]).doubleValue());
    }

}
