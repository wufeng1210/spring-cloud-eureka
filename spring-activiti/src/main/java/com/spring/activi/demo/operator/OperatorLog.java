package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/4 17:18
 * @desrcption: 根据指定底数返回数字的对数。
 */
public class OperatorLog extends Operator {

    public OperatorLog(String name){
        this.name = name;
    }

    public OperatorLog(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        double base = 10;
        if(list.length > 1){
            base = ((Number) list[1]).doubleValue();
        }
        return log(((Number) list[0]).doubleValue(), base);
    }

    /**
     *
     * @author wufeng
     * @date 2018/7/4 18:55
     * @param value 必需。 想要计算其对数的正实数。
     * @param base  可选。 对数的底数。 如果省略 base，则假定其值为 10。
     * @descption
     * @return double
     */
     public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
