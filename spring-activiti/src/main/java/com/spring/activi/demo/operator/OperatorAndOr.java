package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 在参数组中，任何一个参数逻辑值为false，即返回false；只有当所有参数逻辑值为true，才返回true。
 */
public class OperatorAndOr extends Operator {

    private static final String AND = "AND";
    private static final String OR = "OR";

    public OperatorAndOr(String name){
        this.name = name;
    }

    public OperatorAndOr(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list 在参数组中，任何一个参数逻辑值为false，即返回false；只有当所有参数逻辑值为true，才返回true。
     * @return
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        boolean b = true;
        if(this.name.equals(OR)){
            b = false;
        }
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        for (Object object : list){
            Object r = runner.execute(object.toString(), context, null, true, false);
            if(r instanceof Boolean && !(Boolean) r && this.name.equals(AND)){
                return false;
            }
            if(r instanceof Boolean && this.name.equals(OR) && (Boolean) r ){
                return true;
            }
        }
        return b;
    }
}

