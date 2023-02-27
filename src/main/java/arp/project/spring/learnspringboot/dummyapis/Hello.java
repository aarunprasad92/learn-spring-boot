package arp.project.spring.learnspringboot.dummyapis;

public class Hello {
    private String message;
    public Hello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "message='" + message + '\'' +
                '}';
    }
}
