package org.prueba.miapi;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    @GetMapping("/listapersonajes")
    @Cacheable("personajes")
    public List<Personaje> listapersonajes(){
        return MiapiApplication.personajes;
    }
    @GetMapping("/cache/origen") //ejemplo: /cache/origen?lugar=Earth
    public List<Personaje> filtrarOrigen(@RequestParam String lugar){
        List<Personaje> resultado = new ArrayList<>();

        for (Personaje p : MiapiApplication.personajes){
            if (p.getOrigen() != null && p.getOrigen().toLowerCase().contains(lugar.toLowerCase())){
                resultado.add(p);
            }
        }
        return resultado;
    }
    @GetMapping("/cache/especie") //ejemplo: /cache/especie?especie=Human
    public List<Personaje> filtrarEspecie(@RequestParam String especie){
        List<Personaje> resultado = new ArrayList<>();

        for (Personaje p : MiapiApplication.personajes){
            if (p.getEspecie().toLowerCase().contains(especie.toLowerCase())){
                resultado.add(p);
            }
        }
        return resultado;
    }
    @GetMapping("/cache/buscarid") //ejemplo: /cache/buscarid?id=2
    public List<Personaje> buscarPorId(@RequestParam int id){
        List<Personaje> resultado = new ArrayList<>();

        for(int i = 0; i<MiapiApplication.personajes.size(); i++){
            if (MiapiApplication.personajes.get(i).getID() == id){
                resultado.add(MiapiApplication.personajes.get(i));
            }
        }
        return resultado;
    }
    @GetMapping("/cache/nombre") //ejemplo: /cache/nombre?nombre=rick
    public List<Personaje> buscarNombre(@RequestParam String nombre){
        List<Personaje> resultado = new ArrayList<>();

        for(int i = 0; i<MiapiApplication.personajes.size(); i++){
            if (MiapiApplication.personajes.get(i).getNombre().toLowerCase().contains(nombre.toLowerCase())){
                resultado.add(MiapiApplication.personajes.get(i));
            }
        }
        return resultado;
    }
    @GetMapping("/cache/buscarestado") //ejemplo: /cache/buscarestado?estado=Dead
    public List<Personaje> buscarEstado(@RequestParam String estado){
        List<Personaje> resultado = new ArrayList<>();

        for(int i = 0; i<MiapiApplication.personajes.size(); i++){
            if (MiapiApplication.personajes.get(i).getEstado().toLowerCase().contains(estado.toLowerCase())){
                resultado.add(MiapiApplication.personajes.get(i));
            }
        }
        return resultado;
    }
    @GetMapping("/cache/estado") //ejemplo: /cache/estado
    public Map<String, Integer> CalcularEstado(){
      int vivos=0,muertos=0,desconocidos=0;
      for (Personaje p: MiapiApplication.personajes){
          switch (p.getEstado()){
              case "Alive":
                  vivos+=1;
                  break;
              case "Dead":
                  muertos+=1;
                  break;
              case "unknown":
                  desconocidos+=1;
                  break;
          }
      }
      Map<String, Integer> res = new HashMap<>();
      res.put("vivos",vivos);
      res.put("muertos",muertos);
      res.put("desconocidos",desconocidos);
      return res;
    }

    @PostMapping("/cache/agregar")
    public Map<String, String> agregar(@RequestBody Personaje nuevo){
        Map<String, String> res = new HashMap<>();
        try{
            nuevo.setID(MiapiApplication.personajes.size() + 1);
            MiapiApplication.personajes.add(nuevo);
            res.put("resultado","ok");
        }catch (Exception e){
            res.put("error","no se pudo agregar: " + e.getMessage());
        }
        return res;
    }
    @GetMapping("/cache/matar") //ejemplo: /cache/matar?id=2
    public Map<String, String> matar(@RequestParam int id){
        Map<String, String> res = new HashMap<>();
        for (Personaje p : MiapiApplication.personajes){
            if (p.getID() == id){
                p.setEstado("Dead");
                res.put("resultado","ok");
                return res;
            }
        }
        res.put("error","No existe un personaje con ese id");
        return res;
    }
}
