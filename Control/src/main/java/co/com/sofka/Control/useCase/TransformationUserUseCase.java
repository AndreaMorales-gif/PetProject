package co.com.sofka.Control.useCase;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.User;
import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.IUserDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.repository.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformationUserUseCase {
    @Autowired
    private IUserDataRepository data;

    public UserData transform(User user){
        UserData userData = new UserData(user.getIdUser(), user.getName().value(), user.getDate().value(),user.getEmail().value());
        return userData;
    }
    public Iterable<UserData> listar(){
        return data.findAll();
    }

    public String delete(String id) {

        try {
            data.deleteById(id);
            return "Se realizo el borrado con exito";
        }catch(Exception e){
            return "No se pudo realizar el borrado con exito";
        }
    }
}
