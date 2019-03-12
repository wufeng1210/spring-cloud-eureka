package com.spring.activi.demo.util;


import org.apache.commons.lang3.StringUtils;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.util.*;

/**
 * @author: wufeng
 * @date: 2018/6/28 14:08
 * @desrcption:
 */
public class ExpressionUtil {

    /**
     * 计算List<Bean>配置了公式的值
     * @param beanList
     * @return
     */
//    public static List<Map> workOutListBean(List beanList){
//        if(CollectionUtils.isEmpty(beanList)){
//            return Collections.EMPTY_LIST;
//        }else {
//            Class beanClass = beanList.get(0).getClass();
////            Table table = beanClass.getAnnotation(Table.class);//在实体中通过JPA注解获取表名
////            String tableCode = table.name();
////            if(StringUtils.isEmpty(tableCode)){
////                System.out.println("无法计算,该bean没有表名信息");
////            }
//            List<Map> mapList = BeanUtil.convertBeansToMaps(beanList);
//            FormulaService formulaService = SpringContext.getBean(FormulaService.class);
//            List<Formula> formulas = formulaService.queryByTableCode(tableCode);
//            for (Map map : mapList) {
//                JEP jep = getJEP(map);
//                for (Formula formula : formulas) {
//                    String conditionExpr = formula.getConditionExpr();
//                    String formulaExpr = formula.getFormulaExpr();
//                    String evaluate = formula.getEvaluate();
//                    workOutKey(jep,map,conditionExpr,formulaExpr,evaluate);
//                }
//            }
//            return mapList;
//        }
//    }

    /**
     * 非动态配置公式方式
     * @param mapList
     * @param conditionExpr
     * @param formulaExpr
     * @param evaluate
     */
    public static void workOutListMap(List<Map> mapList,String conditionExpr,String formulaExpr, String evaluate){
        for (Map map : mapList) {
            JEP jep = getJEP(map);
            workOutKey(jep,map,conditionExpr,formulaExpr,evaluate);
        }
    }

    /**
     * 计算出表达式并填充
     * @param jep
     * @param map
     * @param conditionExpr
     * @param formulaExpr
     * @param evaluate
     */
    private static void workOutKey(JEP jep,Map map,String conditionExpr, String formulaExpr, String evaluate){
        //如果没有条件
        if(StringUtils.isEmpty(conditionExpr)){
            map.put(evaluate,workOutSingle(jep,formulaExpr));
            //如果有条件 且条件为true
        }else if(workOutBool(jep,conditionExpr)){
            map.put(evaluate,workOutSingle(jep,formulaExpr));
        }
    }

    /**
     * 判断条件表达式
     * @param jep
     * @param expression
     * @return
     */
    private static boolean workOutBool(JEP jep,String expression){
        return (Double)workOutSingle(jep,expression) > 0;
    }

    /**
     * 计算表达式的值
     * @param jep
     * @param expression
     * @return
     */
    private static Object workOutSingle(JEP jep,String expression){
        Object result = null;
        try { //执行
            Node parse = jep.parse(expression);
            result = jep.evaluate(parse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result == null){
            System.out.println("表达式为空");
        }
        return result;
    }

    /**
     * 获取填充好变量的JEP对象
     * @param param
     * @return
     */
    private static JEP getJEP(Map param){
        JEP jep = new JEP();
        Set<Map.Entry> set = param.entrySet();
        for (Map.Entry entry : set) {
            Object entryValue = entry.getValue();
            String entryKey = (String) entry.getKey();
            jep.addVariable(entryKey, entryValue);
        }
        return jep;
    }

    public static void main(String[] args) {

        List<Map> mapList = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("hello", 123.5);
        map1.put("world", 12.4);
        mapList.add(map1);
        map1 = new HashMap();
        map1.put("hello", 123.5);
        map1.put("world", 12.5);
        mapList.add(map1);
        workOutListMap(mapList, "", "hello + world + 1", "java");
        for(Map map : mapList){
            System.out.println(map.get("java"));
        }
    }
}
