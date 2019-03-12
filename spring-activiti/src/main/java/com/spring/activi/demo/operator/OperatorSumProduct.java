package com.spring.activi.demo.operator;

import com.ql.util.express.Operator;
import com.ql.util.express.OperatorOfNumber;

/**
 * @author: wufeng
 * @date: 2018/7/4 10:29
 * @desrcption: 在给定的数组中，将数组间对应的元素相乘，并返回乘积之和。
 *
 * array: 可选。多个数字数组。
 * 主要可用于计算加权和。例如：SUMPRODUCT([1,2,3],[0.1,0.2,0.3])，相当于 1×0.1 + 2×0.2 + 3×0.3=1.4
 */
public class OperatorSumProduct extends Operator {


    public OperatorSumProduct(String name){
        this.name = name;
    }

    public OperatorSumProduct(String aAliasName, String aName, String errorInfo){
        this.aliasName = aAliasName;
        this.name = aName;
        this.errorInfo = errorInfo;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {

        // 获取第一个数组的长度
        int length = ((Object[])list[0]).length;
        Object[] sumProduct = new Object[length];
        // 循环数组，获取数据
        for(int i=0; i<length; i++){
            Object product = 1;
            // 循环list让其累乘
            for(int j=0; j < list.length; j++){
                Object[] array1 = (Object[]) list[j];
                product = OperatorOfNumber.multiply(product, array1[i],this.isPrecise);
            }
            sumProduct[i] = product;
        }
        Object sum = sumProduct[0];
        for(int i=1; i < sumProduct.length; i++){
            sum =  OperatorOfNumber.add(sum, sumProduct[i],this.isPrecise);
        }
        return sum;
    }
}
