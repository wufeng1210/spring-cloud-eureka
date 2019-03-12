package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;

import java.util.List;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 计算countif，统计满足条件的参数个数。
 * 例如：COUNTIF([1,2,3,4], “>2”)，结果为2
 */
public class OperatorCountIf extends Operator {


    public OperatorCountIf(String name){
        this.name = name;
    }

    public OperatorCountIf(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        int length = 0;
        Object[] first = (Object[]) list[0];
        for (int i = 0; i < first.length; i++) {
           StringBuilder str = new StringBuilder();
           str.append(first[i]).append(list[1]);
            Object r = runner.execute(str.toString(), context, null, true, false);
            boolean flag = r instanceof Boolean ? (Boolean) r : false;
            if(flag){
                length ++;
            }
        }
        return length;
    }
}
