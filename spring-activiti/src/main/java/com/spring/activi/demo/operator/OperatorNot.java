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
public class OperatorNot extends Operator {

    public OperatorNot(String name){
        this.name = name;
    }

    public OperatorNot(String aliasName, String aName, String errorInfo){
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
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Object r = runner.execute(list[0].toString(), context, null, true, false);
        return r instanceof Boolean && !(Boolean) r ;
    }
}

