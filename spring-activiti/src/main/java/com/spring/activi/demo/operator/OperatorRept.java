package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 将文本重复一定次数。
 */
public class OperatorRept extends Operator {

    public OperatorRept(String name){
        this.name = name;
    }

    public OperatorRept(String aliasName, String aName, String errorInfo){
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
        StringBuffer result = new StringBuffer();
        int length = ((Number)list[1]).intValue();
        for (int i=0; i<length; i++) {
            result.append(list[0]);
        }
        return result;
    }
}

