package com.zeynalovv.Resource;

import java.util.HashMap;
import java.util.Map;

public class ResourcePool implements AutoCloseable{
    private int maxPoolSize, minPoolSize, creationTimeoutMillis;
    private String validationQuery;
    private Map<Data, ExpensiveResource> pool = new HashMap<>();

    public ResourcePool(ResourcePoolConfig config){
        this.maxPoolSize = config.maxPoolSize;
        this.minPoolSize = config.minPoolSize;
        this.creationTimeoutMillis = config.creationTimeoutMillis;
        this.validationQuery = config.validationQuery;
    }



    public ExpensiveResource acquireResource(Data person){
        if(!pool.containsKey(person) && pool.size() >= maxPoolSize) throw new outOfPoolBoundary("Pool is full!!");
        pool.computeIfAbsent(person, k -> ExpensiveResource.createResource(person));
        return pool.get(person);
    }

    public void releaseResource(ExpensiveResource resource){
        Data person = resource.getData();
        if(!pool.containsKey(person) && pool.size() >= maxPoolSize) throw new outOfPoolBoundary("Pool is full!!");
        pool.computeIfAbsent(person, k -> ExpensiveResource.createResource(person));
    }

    public int sizeOfPool(){
        return pool.size();
    }


    @Override
    public void close() throws Exception {
        pool.clear();
        pool = null;
    }
}
