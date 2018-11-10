public class StopWatch {
    long startTime;
    long endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public StopWatch (){
        startTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        StopWatch obj = new StopWatch();
        for(long i = 0; i < 2147483647; i++);
        System.out.println(obj.getElapsedTime());
    }
}
