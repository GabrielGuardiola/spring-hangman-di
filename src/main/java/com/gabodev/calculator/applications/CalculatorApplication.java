package com.gabodev.calculator.applications;

import com.gabodev.calculator.services.IOperationService;
import org.springframework.stereotype.Component;

@Component
public class CalculatorApplication {

    private final IOperationService operationService;

    public CalculatorApplication(IOperationService operationService){this.operationService = operationService;}

    public Integer multiply(Integer op1, Integer op2){return operationService.multiply(op1,op2);}
    public Integer add(Integer op1, Integer op2){return operationService.add(op1,op2);}
    public Integer sub(Integer op1, Integer op2){return operationService.sub(op1,op2);}
    public Integer divide(Integer op1, Integer op2){return operationService.divide(op1,op2);}
}
