package flow.answer;

import flow.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;


@RestController
public class ReportFlow {


    private StoreResponse storeResponse;

    @Autowired
    public ReportFlow(StoreResponse storeResponse) {
        this.storeResponse = storeResponse;
    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST  )
    public String logReport(@RequestBody UserAnswer answer) {
        storeResponse.store(answer.askedAt, answer.answeredAt, answer.answer);
        return "ok";
    }

    public static class UserAnswer {
        private long askedAt;
        private long answeredAt;
        private String answer;

        public long getAskedAt() {
            return askedAt;
        }

        public void setAskedAt(long askedAt) {
            this.askedAt = askedAt;
        }

        public long getAnsweredAt() {
            return answeredAt;
        }

        public void setAnsweredAt(long answeredAt) {
            this.answeredAt = answeredAt;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        @Override
        public String toString() {
            return "UserAnswer{" +
                    "askedAt=" + askedAt +
                    ", answeredAt=" + answeredAt +
                    ", answer='" + answer + '\'' +
                    '}';
        }
    }
}
