package homework3.enums;

public enum Users {
    USER1("epam", "1234", "");

    public String username;
    public String password;
    public String name;

    Users(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
