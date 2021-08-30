package stef.example.exemple.strategie;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class StrategyFactoryServiceSoap extends StrategyFactorySoap<Qualifier, ServiceSoap> {


    public StrategyFactoryServiceSoap(ListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    @Override
    public Class<Qualifier> strategyAnnotation() {
        return Qualifier.class;
    }

    @Override
    public Class<ServiceSoap> strategyInterface() {
        return ServiceSoap.class;
    }
}
