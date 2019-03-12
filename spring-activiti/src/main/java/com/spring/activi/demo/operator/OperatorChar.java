package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 返回计算机字符集的数字代码所对应的字符
 */
public class OperatorChar extends Operator {

    public OperatorChar(String name){
        this.name = name;
    }

    public OperatorChar(String aliasName, String aName, String errorInfo){
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
        String result = "";
//        char temp;
//        byte[] bytes = ((byte[]) list[0]);
//        int length = bytes.length;
//        for (int i = 0; i < length; i++){
//            temp = (char)bytes[i];
//            result+= temp;
//        }
        return result;
    }
}

