package lms.dto;

public class JwtResponseDao {
    private String token;

    public JwtResponseDao() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtResponseDao(String token) {
        this.token = token;
    }
}
