package com.spring.activi.demo.operator;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.Operator;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 返回数据集中第k个最大值或者最小值。
 */
public class OperatorLargeSmall extends Operator {

    private static final String LARGE = "LARGE";
    private static final String SMALL = "SMALL";

    public OperatorLargeSmall(String name){
        this.name = name;
    }

    public OperatorLargeSmall(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }
    @Override
    public Object executeInner(Object[] list) throws Exception {
        Object[] array = (Object[]) list[0];

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        for (int i = 0; i < array.length; i++) {
            for(int j=0; j < array.length-i-1; j++){
                StringBuilder str = new StringBuilder();
                if(this.name.equals(LARGE)){
                    str.append(array[j]).append("<"+array[j + 1]);
                } else if (this.name.equals(SMALL)) {
                    str.append(array[j]).append(">"+array[j + 1]);
                }
                Object r = runner.execute(str.toString(), context, null, true, false);
                boolean b = r instanceof Boolean ? (Boolean) r : false;
                if (b) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array[(Integer) list[1]-1];
    }
}
