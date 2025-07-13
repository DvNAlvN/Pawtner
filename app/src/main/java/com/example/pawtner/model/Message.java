package com.example.pawtner.model;

public class Message {
    public static final int TYPE_SENT = 0;
    public static final int TYPE_RECEIVED = 1;

    private String content;
    private String time;
    private int type;

    public Message(String content, String time, int type) {
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public String getContent() { return content; }
    public String getTime() { return time; }
    public int getType() { return type; }
}
