package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 计算abs，返回绝对值
 */
public class OperatorAbs extends Operator {


    public OperatorAbs(String name){
        this.name = name;
    }

    public OperatorAbs(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        if(list[0] instanceof Float){
            return Math.abs((Float) list[0]);
        }else if(list[0] instanceof Double){
            return Math.abs((Double)list[0]);
        }else if(list[0] instanceof Long){
            return Math.abs((Long)list[0]);
        }else{
            return Math.abs((Integer) list[0]);
        }
    }
}
