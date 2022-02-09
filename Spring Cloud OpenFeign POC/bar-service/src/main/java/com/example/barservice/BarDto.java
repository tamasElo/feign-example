package com.example.barservice;

public class BarDto {
    private long id;
    private String message;

    public BarDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BarDto{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
