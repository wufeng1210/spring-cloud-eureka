package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption:
 * 删除字符串首尾的空格。
 *  如果字符串内部存在连续多个空格，还会删除至仅剩一个空格
 */
public class OperatorTrim extends Operator {

    public OperatorTrim(String name){
        this.name = name;
    }

    public OperatorTrim(String aliasName, String aName, String errorInfo){
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
         // 删除字符串首尾空格
        String result = list[0].toString().trim();
        //字符串内部存在连续多个空格，还会删除至仅剩一个空格
        return result.replaceAll("\\s{1,}", " ");
    }
}

