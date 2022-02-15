package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadPool {

    private final ExecutorService POOL = Executors.newFixedThreadPool(2);
    private Callable interactive;
    private Callable nonInteractive;

    public Map<Mode, Object> runAllThreads(String filePath) throws Exception {
        interactive = Interactive.getInstance();
        nonInteractive = NonInteractive.getInstance(filePath);
        Map<Mode, Object> results = new HashMap<>();
        Future interactiveThread = POOL.submit(interactive);
        Future nonInteractiveThread = POOL.submit(nonInteractive);
        results.put(Mode.INTERACTIVE, interactiveThread.get());
        results.put(Mode.NONINTERACTIVE, nonInteractiveThread.get());
        POOL.shutdown();
        return results;
    }

    public Object runInteractiveThread() throws ExecutionException, InterruptedException {
        interactive = Interactive.getInstance();
        Future interactiveThread = POOL.submit(interactive);
        return interactiveThread.get();
    }

    public Object runNonInteractiveThread(String filePath) throws ExecutionException, InterruptedException {
        nonInteractive = NonInteractive.getInstance(filePath);
        Future interactiveThread = POOL.submit(nonInteractive);
        return interactiveThread.get();
    }
}
