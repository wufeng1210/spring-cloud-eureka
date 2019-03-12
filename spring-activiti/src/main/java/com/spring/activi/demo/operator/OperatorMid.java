package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 返回文本字符串中从指定位置开始的特定数目的字符，该数目由用户指定。
 */
public class OperatorMid extends Operator {

    public OperatorMid(String name){
        this.name = name;
    }

    public OperatorMid(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * list[0] 必需。 包含要提取字符的文本字符串。
     * list[1] 必需。 文本中要提取的第一个字符的位置。 文本中第一个字符的list[1]为 1，以此类推。
     * list[2] 必需。 指定希望从文本中返回字符的个数。
     * @return
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        String text = list[0].toString();
        int beginIndex = ((Number)list[1]).intValue() - 1;
        int endIndex = beginIndex + ((Number)list[1]).intValue()+1;

        return text.substring(beginIndex, endIndex);
    }
}

