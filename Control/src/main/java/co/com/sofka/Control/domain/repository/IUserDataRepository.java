package co.com.sofka.Control.domain.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDataRepository extends CrudRepository<UserData, String> {
}
