package com.example.springboot1.socket;

/**
 * @author liang.xiongwei
 * @Title: SocketMessage
 * @Package com.intellif.smart.socket
 * @Description
 * @date 2018/12/6 10:13
 */
public class SocketMessage {
    private Integer command;
    private Integer commandId;
    private String  deviceCode;
    private Integer action;
    private String  resource;
    private String  data;

    public Integer getCommand() {
        return command;
    }

    public void setCommand(Integer command) {
        this.command = command;
    }

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
