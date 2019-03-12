package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 16:18
 * @desrcption: 从一个文本字符串的第一个字符开始返回指定个数的字符。
 */
public class OperatorLeft extends Operator {

    public OperatorLeft(String name){
        this.name = name;
    }

    public OperatorLeft(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        String str = list[0].toString();
        return str.substring(0, ((Number) list[1]).intValue());
    }
}
