package stef.example.exemple.strategie;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

@Slf4j
@RequiredArgsConstructor
public abstract class StrategyFactorySoap<A extends Annotation,T> {

    private final ListableBeanFactory beanFactory;

    public T getImplementation(String strategy) throws IllegalAccessException {
        Class<A> annotationClass = strategyAnnotation();
        Class<T> interfaceClass = strategyInterface();

        String[] names = beanFactory.getBeanNamesForAnnotation(annotationClass);

        for (String strategyName : names) {
            log.info("Using strategy : {}",strategyName);
            if (strategyName.equals(strategy)) {
                return beanFactory.getBean(strategyName, interfaceClass);
            }
        }

        throw new IllegalAccessException("There is no \"" + strategy + "\" strategy available for " + interfaceClass.getName());
    }
    public abstract Class<A> strategyAnnotation();
    public abstract Class<T> strategyInterface();
}
