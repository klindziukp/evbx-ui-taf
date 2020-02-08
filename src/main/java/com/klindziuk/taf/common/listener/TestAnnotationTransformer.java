package com.klindziuk.taf.common.listener;

import com.klindziuk.taf.common.annotation.SkipOnProduction;
import com.klindziuk.taf.common.config.ConfigStorage;
import com.klindziuk.taf.common.constant.Env;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Allows to perform actions with annotations
 */
public class TestAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        skipProductionTest(annotation, testMethod);
    }

    /**
     * Skips all test methods
     * @param annotation instance of ITestAnnotation
     * @param testMethod instance of Method
     */
    private void skipProductionTest(ITestAnnotation annotation, Method testMethod) {
        if (ConfigStorage.getConfig().getProfile().equalsIgnoreCase(Env.PROD.getName())) {
            for (Annotation testAnnotation : testMethod.getAnnotations()) {
                if (testAnnotation instanceof SkipOnProduction) {
                    annotation.setEnabled(false);
                }
            }
        }
    }
}
