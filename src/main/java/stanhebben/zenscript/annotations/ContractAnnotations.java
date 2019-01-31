package stanhebben.zenscript.annotations;

import java.lang.annotation.*;


public class ContractAnnotations {
    
    private ContractAnnotations() {
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    @Repeatable(ZenContractNumericStore.class)
    public @interface ZenContractNumeric {
        
        CompareType compareType();
        
        double value() default 0.0D;
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface ZenContractNumericStore {
        
        ZenContractNumeric[] value();
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    @Repeatable(ZenContractStringValidationMethodStore.class)
    public @interface ZenContractStringValidationMethod {
    
        /**
         * The class declaring the validation method
         */
        Class declaringClazz();
    
        /**
         * The name of the validation method.
         * Must be static and return a String containing the error message, or null if success.
         * The parameters must consist of only Strings.
         * The number of parameters must equal <c>1 + additionalParameters().length</c>
         */
        String methodName();
    
        /**
         * Additional parameters to feed the validation method.
         * The actual parameter that is being validated will always be LAST
         */
        String[] additionalParameters() default {};
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    public @interface ZenContractStringValidationMethodStore {
    
        /**
         * The stored Annotations, filled by the JVM and the Repeatable annotation
         */
        ZenContractStringValidationMethod[] value();
    }
}