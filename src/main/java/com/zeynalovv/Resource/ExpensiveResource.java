package com.zeynalovv.Resource;

public class ExpensiveResource implements Manageable {
    private boolean STATE = false;
    private StringBuilder hashCode = new StringBuilder();
    private Data data;
    private ExpensiveResource(Data data){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.data = data;
    }

    public static ExpensiveResource createResource(Data data){
        return new ExpensiveResource(data);
    }

    public Data getData() {
        return data;
    }

    @Override
    public void open() {
        STATE = true;
    }

    @Override
    public void startProcess() {
        if(STATE){
            hashCode.append(data.getName() + data.getSurname() + data.getBirthYear());
        }
        else throw new emptyResource("The resource is empty!");
    }

    @Override
    public void close() {
        STATE = false;
        hashCode = null;
        data = null;
    }
}
