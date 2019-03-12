package com.spring.activi.demo.service.impl;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.instruction.op.OperatorNor;
import com.spring.activi.demo.operator.*;
import com.spring.activi.demo.service.FunctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author: wufeng
 * @date: 2018/7/4 13:43
 * @desrcption:
 */
@Service
public class FunctionServiceImpl implements FunctionService {



    private static Logger logger = LoggerFactory.getLogger(FunctionServiceImpl.class);
    @Override
    public Object expressRun(String value, Map<String, Object> map) {
        Object r = null;
        ExpressRunner runner = new ExpressRunner();
        // 添加函数
        addFunction(runner);
        // 获取上下文
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Set set = map.entrySet();
        Iterator iterable = set.iterator();
        while (iterable.hasNext()) {
            String key = iterable.next().toString();
            Object val =  map.get(key);
            context.put(key, val);
        }
        try {
            r = runner.execute(value, context, null, true, false);
            System.out.println(r);
        }catch (Exception e){
            e.printStackTrace();
        }
        return r;
    }

    public void addFunction(ExpressRunner runner){
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
        runner.addFunction("MOD", new OperatorMod("MOD"));
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
    }
}
