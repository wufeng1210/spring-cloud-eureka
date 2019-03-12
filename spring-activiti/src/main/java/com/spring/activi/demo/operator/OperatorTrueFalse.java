package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;
import org.apache.poi.ss.formula.functions.T;

import javax.swing.table.TableRowSorter;

/**
 * @author: wufeng
 * @date: 2018/7/5 15:22
 * @desrcption: 在参数组中，任何一个参数逻辑值为false，即返回false；只有当所有参数逻辑值为true，才返回true。
 */
public class OperatorTrueFalse extends Operator {

    private static final String TRUE = "TRUE";
    private static final String FALSE = "FALSE";

    public OperatorTrueFalse(String name){
        this.name = name;
    }

    public OperatorTrueFalse(String aliasName, String aName, String errorInfo){
        this.aliasName = aliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    /**
     * @param list
     * @return 返回逻辑值false。返回逻辑值true
     * @throws Exception
     */
    @Override
    public Object executeInner(Object[] list) throws Exception {
        if(this.name.equals(TRUE)){
            return true;
        }else if(this.name.equals(FALSE)){
            return false;
        }
        return null;
    }
}

