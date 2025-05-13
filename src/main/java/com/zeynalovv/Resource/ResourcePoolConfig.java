package com.zeynalovv.Resource;

public class ResourcePoolConfig {
    public final int maxPoolSize, minPoolSize, creationTimeoutMillis;
    public final String validationQuery;

    public ResourcePoolConfig(Builder builder){
        this.maxPoolSize = builder.maxPoolSize;
        this.minPoolSize = builder.minPoolSize;
        this.creationTimeoutMillis = builder.timeoutMillis;
        this.validationQuery = builder.validationQuery;
    }


    public static class Builder{
        private int maxPoolSize = 1, minPoolSize = 0, timeoutMillis = 100;
        private String validationQuery = "adummytex";

        public Builder query(String dummy){
            this.validationQuery = dummy;
            return this;
        }

        public Builder maxPoolSize(int size){
            this.maxPoolSize = size;
            return this;
        }

        public Builder minPoolSize(int size){
            this.minPoolSize = size;
            return this;
        }

        public Builder timeoutMillis(int ms){
            this.timeoutMillis = ms;
            return this;
        }

        public ResourcePoolConfig build(){
            return new ResourcePoolConfig(this);
        }
    }
}
