package com.example.ex_wanzhipeng001.demo_java.tools.eventbus;

/**
 * Created by ex-wanzhipeng001 on 17/8/18.
 */

public class MessageEvent {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEvent(String message) {
        this.message = message;
    }

    private  String message;
}
