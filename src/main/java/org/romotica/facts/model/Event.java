package org.romotica.facts.model;

public class Event {
    String type;
    String name;
    double value;
    String message;

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String toString(){
        return "[Event] " + name;
    }

    public String prettyPrint(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("{ ");
        buffer.append("\"type\":\"").append(type).append("\"");
        buffer.append(", \"name\":\"").append(name).append("\"");
        buffer.append(", \"value\":").append(value);
        buffer.append(", \"message\":\"").append(message).append("\"");
        buffer.append(" }");
        return buffer.toString();
    }
}
