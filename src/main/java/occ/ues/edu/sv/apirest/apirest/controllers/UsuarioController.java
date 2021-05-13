package occ.ues.edu.sv.apirest.apirest.controllers;

import occ.ues.edu.sv.apirest.apirest.models.UsuarioModel;
import occ.ues.edu.sv.apirest.apirest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService userService;

    @GetMapping(path = "/findAll")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return userService.getListUsuarios();
    }

    @GetMapping(path = "/findById/{id}")
    public Optional<UsuarioModel> findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> findByPrioridad(@RequestParam("prioridad") Integer prioridad){
        return userService.findByPrioridad(prioridad);
    }

    @PostMapping(path = "/newUser")
    public UsuarioModel save(@RequestBody UsuarioModel user){
        return this.userService.guardarUsuario(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean delete = userService.deleteUser(id);
        if (delete){
            return "Usuario eliminado";
        }else {
            return "No se pudo eliminar el usuario con id"+id;
        }
    }


}
