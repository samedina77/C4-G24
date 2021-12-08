package co.edu.unab.api.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.encuentraTodosLosClientes();
    }

    @PostMapping()
    public ClienteModel guardarActualizarCliente(@RequestBody ClienteModel cliente){
        return clienteService.guardaActualizaCliente(cliente);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminaClientePorId(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping(path="/nombre/{nombre}")
    public ArrayList<ClienteModel> clientePorNombre(@PathVariable("nombre") String nombre ){
        return clienteService.obtenerPorNombre(nombre);
    }

    @GetMapping(path="/address/{ciudad}/{departamento}")
    public ArrayList<ClienteModel> clientePorAddress(@PathVariable("ciudad") String ciudad,@PathVariable("departamento") String departamento ){
        return clienteService.obtenerClientePorCiudadYDepartamento(ciudad,departamento);
    }

    @GetMapping(path="/puntos/{puntos}")
    public ArrayList<ClienteModel> clientePorMayorIgualPuntos(@PathVariable("puntos") String puntos){

        try {
            return clienteService.obtenerClientesMayorIgualPuntos(Long.parseLong(puntos));
            
        } catch (Exception e) {
            return new ArrayList<ClienteModel>();  //si se produce una excepción enviamos una lista vacia
        }         
        }

    @GetMapping(path="/query")  // Ejemplo:/cliente/query?fecha=2021-12-07
    public ArrayList<ClienteModel> clientePorFechaIgualQue(@RequestParam("fecha") String fechaString){
         try {
            return clienteService.obtenerClientePorFechasIgualQue(LocalDate.parse(fechaString));
             
         } catch (Exception e) {
             return  new ArrayList<ClienteModel>(); //si se produce una excepción enviamos una lista vacia
         }
    }
}