package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 将文本按指定字符串分割成数组。
 */
public class OperatorSplit extends Operator {

    public OperatorSplit(String name){
        this.name = name;
    }

    public OperatorSplit(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * @return
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        return list[0].toString().split(list[1].toString());
    }
}

