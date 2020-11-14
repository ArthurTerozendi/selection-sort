package ERE.AlgoritmoDeOrdenacao;

public class Bench{
    private long runMills = 4000;
    private int repeat = 10;
    private int warmup = 15;
    private int loop = 100;

    public void SetBenchConfig(long runMills, int repeat, int warmup, int loop){
        this.runMills = runMills;
        this.repeat = repeat;
        this.warmup = warmup;
        this.loop = loop;
    }

    public void CreateBench(String benchName, Runnable runnable){
        System.out.println("Rodando bench: " + benchName);
        int max = repeat + warmup;
        float average = 0;
        for (int i = 0; i < max; i++){
            long nops = 0;
            long duration = 0L;
            long start = System.currentTimeMillis();
            while (duration < runMills) {
                for (int j = 0; j < loop; j++) {
                    runnable.run();
                    nops++;

                }
                duration = System.currentTimeMillis() - start;

            }
            float throughput = (nops / (float)duration) * 1000f;
            boolean benchRun = i >= warmup;
            if (benchRun) {
                average = average + throughput;
            }
            System.out.println(String.format("%.4f", throughput) + " ops/s" + (!benchRun ? " (warmup) | " : " | "));
        }
        average = average / repeat;
        System.out.println("\n[ ~" + average + " ops/s ]\n");
    }
}
