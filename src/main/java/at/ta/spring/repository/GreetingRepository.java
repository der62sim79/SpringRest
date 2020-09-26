package at.ta.spring.repository;

import at.ta.spring.modle.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepository extends CrudRepository<Greeting,Integer> {
}
