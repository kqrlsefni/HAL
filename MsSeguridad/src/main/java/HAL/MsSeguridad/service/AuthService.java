package HAL.MsSeguridad.service;

import java.util.List;
import java.util.Optional;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HAL.MsSeguridad.model.UsuarioModel;
import HAL.MsSeguridad.repository.IAuthRepository;

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

    public UsuarioModel update(UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioExistente = authRepository.findById(usuario.getIdUsuario());
    
        if (usuarioExistente.isPresent()) {
            UsuarioModel usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setUsername(usuario.getUsername());
            usuarioActualizado.setPassword(usuario.getPassword());
            return authRepository.save(usuarioActualizado);
        } else {
            return null;
        }
    }

    
    public List<UsuarioModel> findByAll() {
        return (List<UsuarioModel>) authRepository.findAll();
    }


    public boolean eliminarUsuario(int id){
        try{

            authRepository.deleteById(id);
            return true;
        }catch(Exception arr){
            return false;

        }
    }



}
