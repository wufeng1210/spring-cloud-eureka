package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 计算count，返回个数
 */
public class OperatorCount extends Operator {


    public OperatorCount(String name){
        this.name = name;
    }

    public OperatorCount(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        return list.length;
    }
}
