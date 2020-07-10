package guru.springframework.sfgjms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable {

    //not necessary here since we will not be sending the message as JMSObject
    // but as a JMSMessage using json
    static final long serialVersionUID = -8994448476605019623L;

    private UUID id;
    private String message;
}
