package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 20:16
 * @desrcption:
 */
public class OperatorMinMax extends Operator {

    private static final String MAX = "MAX";

    private static final String MIN = "MIN";

    public OperatorMinMax(String name){
        this.name = name;
    }

    public OperatorMinMax(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    public Object executeInner(Object[] list) throws Exception {
        if (list.length == 0){
            throw new Exception("操作数异常");
        }
        Object result = list[0];

        for (int i = 1; i < list.length; i++)
            result = executeInner(result, list[i]);
        return result;
    }

    public Object executeInner(Object op1,
                               Object op2) throws Exception {
        Object result = null;
        int compareResult = Operator.compareData(op1,op2);
        if (this.name.equals(MIN)) {
            if (compareResult < 0)
                result = op1;
            else
                result = op2;
        } else if (this.name.equals(MAX)) {
            if (compareResult < 0)
                result = op2;
            else
                result = op1;
        }
        return result;
    }
}
