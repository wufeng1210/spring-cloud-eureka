package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 16:38
 *
 * @desrcption: 根据指定的字符数，将部分文本字符串替换为不同的文本字符串。
 */
public class OperatorReplace extends Operator {

    public OperatorReplace(String name){
        this.name = name;
    }

    public OperatorReplace(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     *
     * @author wufeng
     * @date 2018/7/5 16:53
     * @param list
     * REPLACE(字符串1,2,4,字符串2)，即将字符串1中的第2位之后的4位（即2,3,4,5位），用字符串2来替换。
     * @descption REPLACE('J234ERTY', 2, 4, '123b') J1234RTY
     * @return java.lang.Object
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {

        int beginIndex = ((Number) list[1]).intValue() - 1;
        int endIndex = (((Number) list[2]) .intValue())+ 1;

        String replaceStr = list[0].toString().substring(beginIndex, endIndex);
        return list[0].toString().replace(replaceStr, list[3].toString());
    }
}
