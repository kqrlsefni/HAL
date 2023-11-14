package HAL.MsSeguridad.service;

import java.util.Optional;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import HAL.MsSeguridad.repository.IAuthRepository;
import HAL.MsSeguridad.model.UsuarioModel;

@Service
public class AuthService {
    
    @Autowired
    IAuthRepository authRepository;

    public UsuarioModel create(UsuarioModel usuario){
        return authRepository.save(usuario);
    }
    
    public Optional<UsuarioModel> getById(int id){
        return authRepository.findById(id);
    }



}
