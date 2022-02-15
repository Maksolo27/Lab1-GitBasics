package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class Main {

    private static Map<Mode, Object> results = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool();
        Mode mode = calculateMode(args);
        switch (mode) {
            case INTERACTIVE:
                results.put(Mode.INTERACTIVE, threadPool.runInteractiveThread());
                break;
            case NONINTERACTIVE:
                results.put(Mode.NONINTERACTIVE, threadPool.runNonInteractiveThread(args[0]));
                break;
            case ALL:
                results = threadPool.runAllThreads(args[0]);
        }
        System.out.println(results.toString());
    }

    private static Mode calculateMode(String[] args){
        Mode mode;
        if (args.length == 1) {
            mode = Mode.NONINTERACTIVE;
        } else if (args.length == 2 && args[1].equals("-all")) {
            mode = Mode.ALL;
        } else {
            mode = Mode.INTERACTIVE;
        }
        return mode;
    }
}
