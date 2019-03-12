package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 16:38
 *
 * @desrcption: 将一个文本字符串中的所有大写字母转换为小写字母。
 */
public class OperatorLower extends Operator {

    public OperatorLower(String name){
        this.name = name;
    }

    public OperatorLower(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     *
     * @author wufeng
     * @date 2018/7/5 16:53
     * @param list
     * LOWER('J234ERTY')
     * j234erty
     * @descption
     * @return java.lang.Object
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        return list[0].toString().toLowerCase();
    }
}
