package flow.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.OffsetDateTime;

@Entity(name = "responses")
public class Response {

    @Id
    @SequenceGenerator(name="responses_id_seq",sequenceName="responses_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="responses_id_seq")
    private BigInteger id;

    private String response;

    @Column(columnDefinition="TIMESTAMP WITH TIMEZONE")
    private OffsetDateTime askedAt;

    @Column(columnDefinition="TIMESTAMP WITH TIMEZONE")
    private OffsetDateTime answeredAt;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setAskedAt(OffsetDateTime askedAt) {
        this.askedAt = askedAt;
    }

    public OffsetDateTime getAskedAt() {
        return askedAt;
    }

    public void setAnsweredAt(OffsetDateTime answeredAt) {
        this.answeredAt = answeredAt;
    }

    public OffsetDateTime getAnsweredAt() {
        return answeredAt;
    }
}
