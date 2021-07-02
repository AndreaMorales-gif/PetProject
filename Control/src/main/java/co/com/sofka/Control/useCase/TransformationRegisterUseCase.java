package co.com.sofka.Control.useCase;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TransformationRegisterUseCase {

    @Autowired
    private IRegisterDataRepository data;

    public RegisterData transform(Register register){
        RegisterData registerData = new RegisterData(register.getIdRegister(), register.getUserId().value(), register.getEntryDate().value());
        return registerData;
    }

    /*public Iterable<RegisterData> listarUsers(String userId) {
        Iterable<RegisterData> profeLindo = data.findAll();
        Iterable<RegisterData> terca;
        Ciclo para recorrer un iterable
        if (profeLindo.idUser = userId){
            terca.add(profelindo.value())
        }
        return terca;} */

   // public Iterable<RegisterData> listarUsers(String userId){
     //   return data.findByIdUser(userId);
   // }


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

    public String validarIngreso(String id) {
        if((Integer.parseInt(id)%2)== (Integer.parseInt(String.valueOf(new Date()))%2)){
           return"Tiene pico y cédula";
        } else{
            return"No tiene pico y cédula";
        }
    }
}
