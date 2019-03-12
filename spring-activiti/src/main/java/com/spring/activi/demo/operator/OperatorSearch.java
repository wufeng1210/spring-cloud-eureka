package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 在第二个文本字符串中查找第一个文本字符串，并返回第一个文本字符串的起始位置的编号，该编号从第二个文本字符串的第一个字符算起。返回0则表示未查找到。
 */
public class OperatorSearch extends Operator {

    public OperatorSearch(String name){
        this.name = name;
    }

    public OperatorSearch(String aliasName, String aName, String errorInfo){
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
        int beginIndex = 0;
        if(list.length > 2){
            beginIndex = ((Number) list[2]).intValue() - 1;
        }
        int result = list[1].toString().indexOf(list[0].toString(), beginIndex)+1;
        return result ;
    }
}

