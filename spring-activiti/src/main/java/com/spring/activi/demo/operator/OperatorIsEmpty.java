package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 判断值是否为空字符串、空对象或者空数组
 */
public class OperatorIsEmpty extends Operator {

    public OperatorIsEmpty(String name){
        this.name = name;
    }

    public OperatorIsEmpty(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * list[0] 将文本转化为数字。
     * @return
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {

        return StringUtils.isBlank(list[0].toString());
    }
}

