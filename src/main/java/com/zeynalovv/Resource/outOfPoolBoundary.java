package com.zeynalovv.Resource;

public class outOfPoolBoundary extends RuntimeException {
    public outOfPoolBoundary(String message) {
        super(message);
    }
}
