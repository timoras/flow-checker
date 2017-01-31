package flow.answer;

import flow.dao.ResponseDao;
import flow.model.Response;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Service
public class StoreResponse {

    private final ResponseDao responseDao;

    @Inject
    public StoreResponse(ResponseDao responseDao) {
        this.responseDao = responseDao;
    }

    public void store(long askedAt, long answeredAt, String answer) {
        Response response = new Response();
        response.setAskedAt(longToDate(askedAt));
        response.setAnsweredAt(longToDate(answeredAt));
        response.setResponse(answer);
        responseDao.save(response);
    }

    private OffsetDateTime longToDate(long timeInMillis) {
        Instant instant = Instant.ofEpochMilli( timeInMillis);
        return OffsetDateTime.ofInstant(instant , ZoneId.of("UTC"));
    }
}
