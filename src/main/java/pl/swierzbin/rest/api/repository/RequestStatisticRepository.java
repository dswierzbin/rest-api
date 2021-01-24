package pl.swierzbin.rest.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.swierzbin.rest.api.entity.RequestStatistic;

@Repository
public interface RequestStatisticRepository extends CrudRepository<RequestStatistic, String> {
}
