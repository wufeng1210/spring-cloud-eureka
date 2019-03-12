package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.spring.activi.demo.util.Arith;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 返回大于等于 0 且小于 1 的均匀分布随机实数。每一次触发计算都会变化。
 */
public class OperatorRand extends Operator {

    private static final int SCALE = 3;

    public OperatorRand(String name){
        this.name = name;
    }

    public OperatorRand(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     *
     * @param list
     * @return 保留三位有效数字
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {

        return Arith.round(Math.random(), SCALE);
    }
}
