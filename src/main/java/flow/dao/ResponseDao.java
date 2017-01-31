package flow.dao;


import flow.model.Response;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface ResponseDao extends CrudRepository<Response, BigInteger> {

}
