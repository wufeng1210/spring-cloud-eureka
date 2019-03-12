package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.spring.activi.demo.util.Arith;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 将多个文本字符串合并成一个文本字符串
 */
public class OperatorConcatenate extends Operator {

    public OperatorConcatenate(String name){
        this.name = name;
    }

    public OperatorConcatenate(String aliasName, String name, String errorInfo){
        this.aliasName = aliasName;
        this.name = name;
        this.errorInfo = errorInfo;
    }

    /**
     *
     * @param list
     * @return
     * example： String str = "concatenate(\"2018\",\"-\",\"07\",\"-\",\"05\")";  return 2018-07-05
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for(Object object : list){
            stringBuffer.append(object);
        }
        return stringBuffer.toString();
    }
}
