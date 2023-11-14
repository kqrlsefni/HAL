package HAL.MsSeguridad.controller;

import java.util.Optional;

//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import HAL.MsSeguridad.service.AuthService;
import HAL.MsSeguridad.model.UsuarioModel;

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
}
