package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 将文本转化为数字。
 */
public class OperatorValue extends Operator {

    public OperatorValue(String name){
        this.name = name;
    }

    public OperatorValue(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * list[0] 将文本转化为数字。
     * @return
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {

        return ((Number)list[0]).intValue();
    }
}

