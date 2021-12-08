package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
    ArrayList <ClienteModel> findByNombre(String nombre);

    @Query("{apellido:'?0'}")//El ?0 marcador de posición le permite sustituir el valor de los argumentos del método en la cadena de consulta JSON.
    ArrayList<ClienteModel> BuscarPorApellido(String apellido);

    @Query("{'address.ciudad':?0}") 
    // @Query(value="{'address.ciudad':?0}",fields="{'nombre':1,'apellido':1}")  //También puede utilizar la propiedad de filtro para restringir el conjunto de propiedades que se asignan al objeto Java  
    ArrayList<ClienteModel> buscarPorCiudad(String ciudad);

}

