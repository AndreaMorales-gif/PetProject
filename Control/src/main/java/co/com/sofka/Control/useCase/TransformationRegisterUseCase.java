package co.com.sofka.Control.useCase;

import co.com.sofka.Control.domain.Register;
import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.IUserDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class TransformationRegisterUseCase {

    @Autowired
    private IRegisterDataRepository data;

    @Autowired
    private IUserDataRepository dataUser;

    public RegisterData transform(Register register){
        RegisterData registerData = new RegisterData(register.getIdRegister(), register.getUserId().value(), register.getEntryDate().value());
        return registerData;
    }

    public Iterable<RegisterData> listar(){

        return data.findAll();
    }
    public RegisterData listarId(String id) {
        return data.findById(id).orElseThrow(RuntimeException::new);
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

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Colombia"));

        if((Integer.parseInt(id)%2)==(Integer.parseInt((String.valueOf(cal.get(Calendar.DAY_OF_MONTH)))))%2){
            if (dataUser.findById(id).equals(Optional.empty())){
                return "El usuario No existe";
            } else {
                    return "Ha entrado exitosamente.";
                }
        } else{
                return "No tiene pico y cédula";
            }
        }
    }

