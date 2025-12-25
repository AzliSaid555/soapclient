package soap;

public class UpdateUserRequest {
    private Long id;
    private String name;
    private String email;
    private String requesterRole;
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRequesterRole() { return requesterRole; }
}