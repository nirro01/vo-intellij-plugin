package com.github.nirro01.vointellijplugin.actions.common;

import java.text.MessageFormat;

public class VMDetails {
    private final String host;
    private final String user;
    private final String password;
    private final int port;

    public VMDetails(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String buildLogMessage() {
        return MessageFormat.format("User: {0}, Password: {1}, Host: {2}, Port: {3}",
                user, password, host, port);
    }
}