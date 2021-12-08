package co.edu.unab.api.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
      ArrayList<ClienteModel> findByNombre (String nombre);

      @Query(value = "{'address.ciudad':?0,'address.departamento':?1}",fields="{'address.ciudad':1,'apellido':1}")
      ArrayList<ClienteModel> clientesPorCiudad(String ciudad,String departamento);
    
      ArrayList<ClienteModel> findByPuntosGreaterThanEqual(Long puntos);

      @Query("{'puntos':{$lte:?0}}")
      ArrayList<ClienteModel> clientesMenorIgualPuntos(Long puntos);

      @Query("{'registro' : {'$eq' : ?0}}")
      ArrayList<ClienteModel> BuscarClientePorFechaRegistroIgualQue(LocalDate fecha);





}

