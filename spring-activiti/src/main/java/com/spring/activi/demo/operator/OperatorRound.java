package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;
import com.spring.activi.demo.util.Arith;

/**
 * @author: wufeng
 * @date: 2018/7/4 15:43
 * @desrcption: 将数字四舍五入到指定的位数
 */
public class OperatorRound extends Operator {

    public OperatorRound(String name){
        this.name = name;
    }

    public OperatorRound(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    public Object executeInner(Object[] list) throws Exception {
        return executeInner(list[0], list[1]);
    }

    /**
     *
     * @author wufeng
     * @date 2018/7/6 16:30
     * @param op1 四舍五入的数字
     * @param op2 需要保留的位数
     * @descption
     * @return java.lang.Object
     */
    public Object executeInner(Object op1,Object op2) throws Exception {
        double r = OperatorOfNumber.round(
                ((Number) op1).doubleValue(), ((Number) op2).intValue());
        return new Double(r);
    }
}
