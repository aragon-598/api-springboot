package occ.ues.edu.sv.apirest.apirest.services;

import occ.ues.edu.sv.apirest.apirest.models.UsuarioModel;
import occ.ues.edu.sv.apirest.apirest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    //Parecido a un inject en jsf
    @Autowired
    UsuarioRepository userRepository;

    public ArrayList<UsuarioModel> getListUsuarios(){
        return (ArrayList<UsuarioModel>)userRepository.findAll();
    }

    public Optional<UsuarioModel> findById(Long id){
        return userRepository.findById(id);
    }

    public UsuarioModel guardarUsuario(UsuarioModel user){
        return userRepository.save(user);
    }

    public ArrayList<UsuarioModel> findByPrioridad(Integer prioridad){
        return userRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
