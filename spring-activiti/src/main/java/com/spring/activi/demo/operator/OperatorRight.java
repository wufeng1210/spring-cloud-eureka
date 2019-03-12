package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 返回文本值中最右边的字符。
 */
public class OperatorRight extends Operator {

    public OperatorRight(String name){
        this.name = name;
    }

    public OperatorRight(String aliasName, String aName, String errorInfo){
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
        int beginIndex = list[0].toString().length();
        if(list.length == 2){
            beginIndex = ((Number) list[1]).intValue();
        }
        return list[0].toString().substring(list[0].toString().length()-beginIndex, list[0].toString().length()) ;
    }
}

