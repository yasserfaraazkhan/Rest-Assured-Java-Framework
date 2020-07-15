package pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "users", "first_name", "last_name", "career", "phone" })
public class UsersPOJO {

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("career")
    private String career;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("users")
    private List<UsersPOJO> users;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("users")
    public List<UsersPOJO> getUsers() {
        return users;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return first_name;
    }

    @JsonProperty("first_name")
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return first_name;
    }

    @JsonProperty("last_name")
    public void setLastNameId(String last_name) {
        this.last_name = last_name;
    }

    @JsonProperty("career")
    public String getCareer() {
        return first_name;
    }

    @JsonProperty("career")
    public void setCareer(String career) {
        this.career = career;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
