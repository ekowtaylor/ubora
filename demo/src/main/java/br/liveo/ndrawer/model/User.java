package br.liveo.ndrawer.model;;

/**
 * User model class
 */
public class User {

    /** Property username */
    String username;

    /** Property password */
    String password;

    /** Property name */
    String name;

    /** Property roles */
    String roles;

    /** Property id */
    int id;

    /** Property session */
    String session;

    /** Property token */
    String token;

    /**
     * Constructor
     */
    public User() {
    }

    /**
     * Gets the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the username
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the roles
     */
    public String getRoles() {
        return this.roles;
    }

    /**
     * Sets the roles
     */
    public void setRoles(String value) {
        this.roles = value;
    }

    /**
     * Gets the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the session
     */
    public String getSession() {
        return this.session;
    }

    /**
     * Sets the session
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * Gets the token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Sets the token
     */
    public void setToken(String value) {
        this.token = value;
    }
}