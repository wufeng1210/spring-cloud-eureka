package com.spring.activi.demo.enums;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.instruction.op.OperatorNor;
import com.spring.activi.demo.operator.*;
import com.spring.activi.demo.pojo.Functions;
import com.spring.activi.demo.util.Arith;
import com.spring.activi.demo.util.Calculator;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: wufeng
 * @date: 2018/6/28 18:43
 * @desrcption: 数学函数枚举类
 */
public enum MathEnum {

    /**返回参数的平均值（算术平均值）*/
    AVERAGE("AVERAGE"),
    /**统计参数个数。*/
    COUNT("COUNT"),
    /**统计满足条件的参数个数。**/
    COUNTIF("COUNTIF"),
    /**返回一组值中的最大值。*/
    MAX("MAX"),
    /**返回一组值中的最小值。*/
    MIN("MIN"),
    /**返回数据集中第k个最大值。*/
    LARGE("LARGE"),
    /**返回数据集中第k个最小值。*/
    SMALL("SMALL"),
    /**返回数字的绝对值。**/
    ABS("ABS"),
    /**将数字四舍五入到指定的位数。*/
    ROUND("ROUND"),
    /**返回将参数 number 向上舍入（沿绝对值增大的方向）为最接近的指定基数的倍数。*/
    EILING("EILING"),
    /**将参数number向下舍入（沿绝对值减小的方向）为最接近的significance的倍数。*/
    FLOOR("FLOOR"),
    /**将数字向下舍入到最接近的整数。*/
    INT("INT"),
    /***根据指定底数返回数字的对数。*/
    LOG("LOG"),
    /**返回两数相除的余数。 结果的符号与除数相同。*/
    MOD("MOD"),
    /**返回数字乘幂的结果。*/
    POWER("POWER"),
    /**函数使所有以参数形式给出的数字相乘并返回乘积。*/
    PRODUCT("PRODUCT"),
    /**返回正的平方根。*/
    SQRT("SQRT"),
    /**函数使所有以参数形式给出的数字相加并返回和。*/
    SUM("SUM"),
    /**在给定的数组中，将数组间对应的元素相乘，并返回乘积之和。*/
    SUMPRODUCT("SUMPRODUCT"),
    /**将数字舍入到指定的小数位数，以十进制数格式对该数进行格式设置，并以文本形式返回结果。*/
    FIXED("FIXED"),
    /**返回大于等于 0 且小于 1 的均匀分布随机实数。每一次触发计算都会变化。*/
    RAND("RAND");

    private String type;

    MathEnum(String type){
        this.type = type;
    }

    private static ExpressRunner runner = new ExpressRunner();

    public static void main(String[] args) {
//        String str ="sum(1,sum(sum(1,2),4),3)+2*3+5+sum(1,-9)+sum(1,abs(-3.1))<9";
//       String str = "1+SUM(1,3,3)+2*3+5+ABS(-8)";
//        String str = "COUNTIF([1,2,3,4], “>2”)".toLowerCase().replace("“", "'").replace("”", "'");
//        String str = "round(2.56, 0)";
//        String str = "min(1,2,3,4,6,2)";
//       String str = "remainder(3,3)";
//        String str = "product(1,2,3)";
//        String str = "sumproduct([1,2,3,4],[0.1,0.2,0.3,0.4],[1,2,3,4])";
//        String str = "rand()";
//        String str = "concatenate(\"2018\",\"-\",\"07\",\"-\",\"05\")";
//       String str = "exact(10, 1)";
//       String str = "LOWER('J234ERTY')";
//        String str = "REPLACE('J234ERTY', 2, 4, '123b')";

//        String str = "RIGHT('嗯嗯啊额额')";
        String str = "AND(80>70, 80>70, 80>70)";
       double result = Calculator.conversion(str);
       if(StringUtils.isNumeric(String.valueOf(result))){
           System.out.println(str + " = " + result);
       } else {
           // 解析函数
           List<Functions> list = getFunctionsList(str);
           //返回函数排序
           List<Functions> functionsList = sort(list);
           count(functionsList, str);

           runner.addFunction("ABS", new OperatorAbs("ABS"));
           runner.addFunction("AND", new OperatorAndOr("AND"));
           runner.addFunction("OR", new OperatorAndOr("OR"));
           runner.addFunction("CEILING", new OperatorCeiling("CEILING"));
           runner.addFunction("CHAR", new OperatorChar("CHAR"));
           runner.addFunction("CONCATENATE", new OperatorConcatenate("CONCATENATE"));
           runner.addFunction("COUNTIF", new OperatorCountIf("COUNTIF"));
           runner.addFunction("EXACT", new OperatorExact("EXACT"));
           runner.addFunction("FIXED", new OperatorFixed("FIXED"));
           runner.addFunction("IF", new OperatorIF("IF"));
           runner.addFunction("INT", new OperatorInt("INT"));
           runner.addFunction("ISEMPTY", new OperatorIsEmpty("ISEMPTY"));
           runner.addFunction("LARGE", new OperatorLargeSmall("LARGE"));
           runner.addFunction("LEFT", new OperatorLeft("LEFT"));
           runner.addFunction("LEN", new OperatorLen("LEN"));
           runner.addFunction("LOG", new OperatorLog("LOG"));
           runner.addFunction("LOWER", new OperatorLower("LOWER"));
           runner.addFunction("MID", new OperatorMid("MID"));
           runner.addFunction("MAX", new OperatorMinMax("MAX"));
           runner.addFunction("MIN", new OperatorMinMax("MIN"));
           runner.addFunction("NOT", new OperatorNor("NOT"));
           runner.addFunction("POWER", new OperatorPower("POWER"));
           runner.addFunction("PRODUCT", new OperatorProduct("PRODUCT"));
           runner.addFunction("RAND", new OperatorRand("RAND"));
           runner.addFunction("REMAINDER", new OperatorMod("REMAINDER"));
           runner.addFunction("REPLACE", new OperatorReplace("REPLACE"));
           runner.addFunction("REPT", new OperatorRept("REPT"));
           runner.addFunction("RIGHT", new OperatorRight("RIGHT"));
           runner.addFunction("ROUND", new OperatorRound("ROUND"));
           runner.addFunction("SEARCH", new OperatorSearch("SEARCH"));
           runner.addFunction("SPLIT", new OperatorSplit("SPLIT"));
           runner.addFunction("SQRT", new OperatorSqrt("SQRT"));
           runner.addFunction("SUM", new OperatorSum("SUM"));
           runner.addFunction("SUMPRODUCT", new OperatorSumProduct("SUMPRODUCT"));
           runner.addFunction("SMALL", new OperatorLargeSmall("SMALL"));
           runner.addFunction("TRIM", new OperatorTrim("TRIM"));
           runner.addFunction("TRUE", new OperatorTrueFalse("TRUE"));
           runner.addFunction("FALSE", new OperatorTrueFalse("FALSE"));
           runner.addFunction("UPPER", new OperatorUpper("UPPER"));
           runner.addFunction("VALUE", new OperatorValue("VALUE"));
           runner.addFunction("XOR", new OperatorXor("XOR"));








           DefaultContext<String, Object> context = new DefaultContext<String, Object>();
           context.put("a",1);
           context.put("b",2);
           context.put("c",3);
           String express = "a+b*c";
           try {
               Object r = runner.execute(str, context, null, true, false);
               System.out.println(r);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    public static String count(List<Functions> list, String str){
        String result = "";
        for(int i=0; i < list.size(); i++){

        }
        return result;
    }


    public static List<Functions> sort(List<Functions> list) {
        List<Functions> functionsList = new ArrayList<>();
        for (int i=0; i < list.size(); i++) {
            Functions f = list.get(i);
            Functions function = new Functions();
            for(int j=0; j<list.size(); j++){
                Functions functions = list.get(j);
                // 内嵌套函数
                if(f.getSuffix() < functions.getSuffix() && f.getEndIndex() > functions.getEndIndex()){
                    function = functions;
                    //外嵌套函数
                }else if(f.getSuffix() > functions.getSuffix() && f.getEndIndex() < functions.getEndIndex()){
                   function = functions;
                }
            }
            if(StringUtils.isEmpty(function.getFunction())){
                function = f;
            }
            functionsList.add(function);
        }
        System.out.println(functionsList);
        return functionsList;
    }


    /**
     *
     * @author wufeng
     * @date 2018/6/29 11:26
     * @param str 遍历的字符串
     * @descption
     * @return int 返回当前函数最后一个)的下标
     */
    public static int returnIndex(String str){
        Stack stack = new Stack<>();
        int left = 0;
        int right = 0;
        for(int i = 0; i < str.length(); i++){
            char  item =  str.charAt(i);
            if('(' == item){
               stack.push(item);
               left++;
            }

            if(')' == item){
                stack.push(item);
                right++;
                boolean b =  right % left == 0;
                if (!stack.peek().equals(stack.get(0)) && b) {
                    stack.pop();
                    System.out.println("i::"+i);
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     *  获取字符串中函数方法和下标
     * @author wufeng
     * @date 2018/6/29 14:37
     * @param
     * @descption
     * @return
     */
    public static List<Functions> getList(String str){
        List<Functions> list = new ArrayList<>();
        int count = 0;
        MathEnum[] array = MathEnum.values();

        for(int j = 0; j < array.length; j++){
                // 解析函数方法
             Functions functions = new Functions();
                String value = str.substring(count, str.length());
                if(value.indexOf(array[j].type.toUpperCase()) > -1){
                    int suffix = str.indexOf(array[j].type.toUpperCase());
                    String formula = array[j].type.toUpperCase();
                    int endIndex = returnIndex(str.substring(suffix));
                    functions.setEndIndex(endIndex);
                    functions.setFormula(formula);
                    functions.setSuffix(suffix);
                    list.add(functions);
                    count = formula.length();
                    String substring = str.substring(suffix, suffix+endIndex+1);
                    if(count(substring, array[j].type.toUpperCase()) > 1){
                        substring = str.substring(suffix+formula.length(), suffix+endIndex+1);
                        List<Functions> functionsList = getList(substring);
                        for(Functions functions1: functionsList){
                            list.add(functions1);
                        }
                    }
                }
        }
        return list;
    }
    /**
     *  获取字符串中函数方法和下标
     * @author wufeng
     * @date 2018/6/29 14:37
     * @param
     * @descption
     * @return
     */
    public static List<Functions> getFunctionsList(String str){
        List<Functions> list = new ArrayList<>();
        MathEnum[] array = MathEnum.values();
        for (int i = 0; i < str.length(); i++) {
            String value = str.substring(i);
            for(int j = 0; j < array.length; j++){
                // 解析函数方法
                Functions functions = new Functions();
                if(value.indexOf(array[j].type.toUpperCase()) == 0){
                    int suffix = i + value.indexOf(array[j].type.toUpperCase());
                    String formula = array[j].type.toUpperCase();
                    int endIndex = i + returnIndex(value);
                    String substring = str.substring(suffix, endIndex+1);
                    functions.setEndIndex(endIndex);
                    functions.setFormula(formula);
                    functions.setSuffix(suffix);
                    functions.setFunction(substring);
                    list.add(functions);
                }
            }
        }
        return list;
    }
    public static int count(String text,String sub){
        int count =0, start =0;
        while((start=text.indexOf(sub,start))>=0){
            start += sub.length();
            count ++;
        }
        return count;
    }

    /**
     *
     * @author wufeng
     * @date 2018/6/29 15:19
     * @param
     * @descption
     * @return
     */
    public static String Sum(String str){
        double d = 0;
        if (stack(str) > 2) {
            int a = str.indexOf("(");
            int b = str.lastIndexOf(")");
            System.out.println(b);
            String value = str.substring(a+1,b);
            System.out.println(value);
        } else {
            int a = str.indexOf("(");
            int b = str.indexOf(")");
            String value = str.substring(a+1, b);
            String[] array = value.split(",");
            double[] arrayDouble = new double[array.length];
            for(int i=0; i<array.length; i++){
                arrayDouble[i] = Double.parseDouble(array[i]);
            }
            d = Arith.addAll(arrayDouble);
            System.out.println(Arith.addAll(arrayDouble));
        }
        return String.valueOf(d);
    }
    /**
     *
     * @author wufeng
     * @date 2018/6/29 15:11
     * @param str
     * @descption  abs取绝对值
     * @return java.lang.String
     */
    public static String Abs(String str){
        double d = 0;
        if (stack(str) > 2) {

        } else {
            int a = str.indexOf("(");
            int b = str.indexOf(")");
            String value = str.substring(a+1, b);
            System.out.println(value);
            d = Math.abs(Double.parseDouble(value));
        }
       return String.valueOf(d);
    }

    public static int stack(String str){
        Stack stack = new Stack();
        for(int i = 0; i < str.length(); i++){
            char  item =  str.charAt(i);
            if('(' == item){
                stack.push(item);
            }
            if(')' == item){
                stack.push(item);
            }
        }
        return stack.size();
    }
    /**
     *
     * @author wufeng
     * @date 2018/6/29 10:30
     * @param str
     * @descption  判断是否会有函数
     * @return boolean
     */
    public static boolean judgeIncludeFunction(String str){
        MathEnum[] array = MathEnum.values();
        for(int i = 0; i < array.length; i++){
            // 解析函数方法
            if(str.contains(array[i].type.toUpperCase())){
              return true;
            }
        }
        return false;
    }
}
