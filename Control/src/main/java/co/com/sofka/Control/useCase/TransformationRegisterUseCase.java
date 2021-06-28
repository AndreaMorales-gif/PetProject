package co.com.sofka.Control.useCase;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformationRegisterUseCase {

    @Autowired
    private IRegisterDataRepository data;

    public RegisterData transform(Register register){
        RegisterData registerData = new RegisterData(register.getIdRegister(), register.getUserId().value(), register.getEntryDate().value());
        return registerData;
    }
    public Iterable<RegisterData> listar(){
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
