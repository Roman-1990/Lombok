package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.internal.loader.Resource;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Register {
    @JsonProperty("register")
    private Register register;
    @JsonProperty("data")
    private Resource resource;
    private Integer id;


}
