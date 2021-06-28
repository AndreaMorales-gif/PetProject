package co.com.sofka.Control.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterDataRepository extends CrudRepository<RegisterData, String> {

}
