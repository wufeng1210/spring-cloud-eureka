package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 16:18
 * @desrcption: 比较两个数字是否一致，一致返回true，否则返回false，区分大小写
 */
public class OperatorExact extends Operator {

    public OperatorExact(String name){
        this.name = name;
    }

    public OperatorExact(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        if (list[0].equals(list[1])) {
            return true;
        } else {
            return false;
        }
    }
}
