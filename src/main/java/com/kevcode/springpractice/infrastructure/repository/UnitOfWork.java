package com.kevcode.springpractice.infrastructure.repository;

import com.kevcode.springpractice.application.base.IAppService;
import com.kevcode.springpractice.domain.entities.base.EntityBase;
import com.kevcode.springpractice.domain.repository.IGenericRepository;
import com.kevcode.springpractice.domain.repository.IUnitOfWork;
import com.kevcode.springpractice.domain.services.CustomerDomainService;
import com.kevcode.springpractice.domain.services.base.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
public class UnitOfWork implements IUnitOfWork {
    @Autowired
    private ApplicationContext appContext;

    public <T extends EntityBase,U> IGenericRepository<T,U> getRepositoryFor(Class<T> clazz) {
        ResolvableType type = ResolvableType.forClassWithGenerics(IGenericRepository.class, clazz);
        return (IGenericRepository<T,U>) appContext.getBeanProvider(type).getObject();
    }

    public <T extends IDomainService> IDomainService getService(Class<T> clazz){
        return (IDomainService) appContext.getBeanProvider(ResolvableType.forClass(clazz)).getObject();
    }
public <T extends IAppService> IAppService getAppService(Class<T> clazz){
        return (IAppService) appContext.getBeanProvider(ResolvableType.forClass(clazz)).getObject();
}
    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }
}
