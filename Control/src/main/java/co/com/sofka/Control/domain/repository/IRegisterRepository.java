package co.com.sofka.Control.domain.repository;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.value.RegisterId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegisterRepository extends CrudRepository<Register, RegisterId> {

}
