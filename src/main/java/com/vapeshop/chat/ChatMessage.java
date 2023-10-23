package com.vapeshop.chat;

import java.time.OffsetDateTime;

public class ChatMessage
{
    private OffsetDateTime timestamp;
    private Type type;
    private String user;
    private String content;
    // accessor and mutator methods
    public static enum Type
    {
        STARTED, JOINED, ERROR, LEFT, TEXT
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "timestamp=" + timestamp +
                ", type=" + type +
                ", user='" + user + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}