import com.zeynalovv.Resource.*;

public class main {
    public static void main(String[] args) {
        ResourcePoolConfig settings = new ResourcePoolConfig.Builder()
                .maxPoolSize(5)
                .minPoolSize(0)
                .timeoutMillis(100)
                .query("salam")
                .build();
        Data abbas = new Data("Abbas", "Zeynalov", 2006);
        Data flankes = new Data("Abba", "Zeynalov", 2006);
        Data data1 = new Data("Abba", "Zeynalo", 2006);
        Data data2 = new Data("bba", "Zeynalo", 2006);
        Data data3 = new Data("ba", "Zeynalo", 2006);
        Data data4 = new Data("b", "Zeynal", 2006);
        try(ResourcePool pool = new ResourcePool(settings)) {
            ExpensiveResource abbasR = pool.acquireResource(abbas);
            System.out.println(pool.sizeOfPool());
            ExpensiveResource flankesR = pool.acquireResource(flankes);
            System.out.println(pool.sizeOfPool());
            ExpensiveResource data1R = pool.acquireResource(data1);
            System.out.println(pool.sizeOfPool());
            ExpensiveResource data2R = pool.acquireResource(data2);
            System.out.println(pool.sizeOfPool());
            ExpensiveResource data3R = pool.acquireResource(data3);
            System.out.println(pool.sizeOfPool());
            ExpensiveResource data4R = pool.acquireResource(data4);
            System.out.println(pool.sizeOfPool());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
