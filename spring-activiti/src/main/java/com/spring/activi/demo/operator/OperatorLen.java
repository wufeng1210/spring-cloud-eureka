package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 16:18
 * @desrcption: 返回文本字符串中的字符个数。
 */
public class OperatorLen extends Operator {

    public OperatorLen(String name){
        this.name = name;
    }

    public OperatorLen(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        String str = list[0].toString();
        return str.length();
    }
}
