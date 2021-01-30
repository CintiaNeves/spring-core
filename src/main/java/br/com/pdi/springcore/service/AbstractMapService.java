package br.com.pdi.springcore.service;

import br.com.pdi.springcore.domain.DomainObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract  class AbstractMapService {

    protected Map<Long, DomainObject> domainMap;

    public AbstractMapService(){
        domainMap = new HashMap<>();
    }

    public List<DomainObject> listAll(){
        return new ArrayList<>(domainMap.values());
    }

    public DomainObject getById(Long id){
        return domainMap.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject){
        if(domainObject != null){
            if(domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);
            return domainObject;
        }else{
            throw new RuntimeException("Object can't be null");
        }
    }

    private Long getNextKey() {
        if(domainMap.isEmpty()){
            return 1L;
        }else{
            return Collections.max(domainMap.keySet()) + 1;
        }
    }

    public void delete(Long id){
        domainMap.remove(id);
    }

    protected abstract void loadDomainObjects();
}
