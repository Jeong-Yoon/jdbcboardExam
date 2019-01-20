package my.examples.jdbcboard.dto;

public class User {
    private Long id;
    private String email;
    private String name;
    private String passwd;

    public User(Long id,String name,String passwd){
        this.id = id;
        this.name = name;
        this.passwd = passwd;

    }

    public User(String name, String email, String passwd) {
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }

    public User(Long id, String email, String name, String passwd) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.passwd = passwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
