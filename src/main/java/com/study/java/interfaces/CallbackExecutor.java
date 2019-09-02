package com.study.java.interfaces;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yan on  02/09/2019.
 */
public class CallbackExecutor {

    private Queue<Callback> queue = new LinkedList<>();

    public void execute(Callback callback){
        queue.add(callback);
    }

    public void run(){
        queue.forEach(e->e.callBack());
    }

}
