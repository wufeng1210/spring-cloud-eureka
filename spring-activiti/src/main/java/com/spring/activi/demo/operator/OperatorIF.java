package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 判断一个条件能否满足；如果满足返回一个值，如果不满足则返回另外一个值。
 */
public class OperatorIF extends Operator {

    public OperatorIF(String name){
        this.name = name;
    }

    public OperatorIF(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * lsit[0] 条件
     * list[1] 满足时返回此值
     * list[2] 不满足时返回此数
     * @return 判断一个条件能否满足；如果满足返回一个值，如果不满足则返回另外一个值。
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Object r = runner.execute(list[0].toString(), context, null, true, false);
        return r instanceof Boolean && (Boolean) r ? list[1] : list[2];
    }
}

