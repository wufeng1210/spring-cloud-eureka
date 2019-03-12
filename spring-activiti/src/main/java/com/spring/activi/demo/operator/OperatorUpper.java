package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 将一个文本字符串中的所有小写字母转换为大写字母
 */
public class OperatorUpper extends Operator {

    public OperatorUpper(String name){
        this.name = name;
    }

    public OperatorUpper(String aliasName, String aName, String errorInfo){
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
         // 将一个文本字符串中的所有小写字母转换为大写字母
        return list[0].toString().toUpperCase();
    }
}

