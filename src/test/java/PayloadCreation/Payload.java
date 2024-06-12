package PayloadCreation;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Payload {
    private List<User> users;
    private List<Address> addresses;

    public Payload(List<User> users, List<Address> addresses) {
        this.users = users;
        this.addresses = addresses;
    }

    @JsonProperty("users")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonProperty("addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
