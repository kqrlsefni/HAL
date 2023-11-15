package HAL.MsSeguridad.controller;

import java.util.List;
import java.util.Optional;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HAL.MsSeguridad.model.UsuarioModel;
import HAL.MsSeguridad.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/create")
    public UsuarioModel create(@RequestBody UsuarioModel usuario) {
        return authService.create(usuario);
    }

    @GetMapping("/getById/{id}")
    public Optional<UsuarioModel> getById(@PathVariable int id) {
        return authService.getById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioModel> updateUsuario(@RequestBody UsuarioModel usuario) {
        UsuarioModel usuarioActualizado = authService.update(usuario);

        if (usuarioActualizado != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByAll")
    public ResponseEntity<List<UsuarioModel>> findByAll() {
        List<UsuarioModel> usuarios = authService.findByAll();

        if (!usuarios.isEmpty()) {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") int id){
        boolean ok= this.authService.eliminarUsuario(id);
        
        if(ok){
            return "Se elimino el usuario con id "+ id;

        }else{
            return "No se pudo eliminar el usuario con id"+ id;
        }
    }

}
