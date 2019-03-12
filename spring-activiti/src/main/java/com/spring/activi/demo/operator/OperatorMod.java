package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 返回两数相除的余数。 结果的符号与除数相同。
 */
public class OperatorMod extends Operator {


    public OperatorMod(String name){
        this.name = name;
    }

    public OperatorMod(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        return executeInner(list[0], list[1]);
    }

    public Object executeInner(Object op1,Object op2) throws Exception {
        BigDecimal[] results = new BigDecimal[]{};
        if(op1 instanceof Integer && op2 instanceof Integer){
            BigDecimal bigDecimal = new BigDecimal((Integer) op1);
            results = bigDecimal.divideAndRemainder(BigDecimal.valueOf((Integer)op2));
            return results[1];
        }
        return null;
    }
}
