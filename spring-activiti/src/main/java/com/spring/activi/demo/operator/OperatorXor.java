package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 *
 * @desrcption: 对参数逻辑值求反；就是把括号里为true的值变成false，括号里为false的值变为true。
 */
public class OperatorXor extends Operator {

    public OperatorXor(String name){
        this.name = name;
    }

    public OperatorXor(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * lsit[0] 条件
     * @return 括号里为true的值变成false，括号里为false的值变为true。
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        int result = 0;
        String startStr = list[0].toString();
        for (int i = 1; i < list.length; i++) {
            if(!startStr.equals(list[i])){
                return 1;
            }
        }
        return result ;
    }
}

