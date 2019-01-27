package stanhebben.zenscript.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ZenContractNumeric {
    
    CompareType compareType();
    
    double value() default 0.0D;
}
