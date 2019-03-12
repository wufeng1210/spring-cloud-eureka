package com.spring.activi.demo.pojo;

/**
 * @author: wufeng
 * @date: 2018/6/29 17:43
 * @desrcption: 函数对象
 */
public class Functions {

    // 函数名
    private String formula;

    // 最后一个）下标
    private int endIndex;

    //第一个下标
    private int suffix;
    // 公式
    private String function;

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getSuffix() {
        return suffix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }
}
