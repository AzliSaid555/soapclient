package soap;

import com.client.soapclient.User;

public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String role;

    public static UserResponse from(User u) {
        UserResponse r = new UserResponse();
        r.id = u.getId();
        r.name = u.getName();
        r.email = u.getEmail();
        r.role = u.getRole();
        return r;
    }
}
