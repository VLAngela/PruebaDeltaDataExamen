package com.AVazquez.PruebaDeltaData.Controller;

import com.AVazquez.PruebaDeltaData.ML.Credito;
import com.AVazquez.PruebaDeltaData.ML.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/Creditos")
public class CreditosController {

    String baseUrl = "http://localhost:8080";
    RestTemplate restTemplate = new RestTemplate();
    Result result = new Result();

    @GetMapping
    public String Index(Model model) {

        try {

            ResponseEntity<Result<Credito>> responseC = restTemplate.exchange(baseUrl + "/CreditoService",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<Result<Credito>>() {
            });

            Result<Credito> creditos = responseC.getBody();

            if (creditos.correct) {

                model.addAttribute("Credito", creditos.objects);
            } else {

                model.addAttribute("Credito", null);
            }
        } catch (Exception ex) {
            ex.getLocalizedMessage();

        }

        return "CreditosIndex";

    }

    @GetMapping("/form/{Id}")
    public String formulario(@PathVariable int Id, Model model) {

        if (Id == 0) {

            Credito credito = new Credito();

            model.addAttribute("Credito", credito);
        }
        return "FormCredito";

    }

    @GetMapping("/formEditar")
    public String Editar(@ModelAttribute Credito credito, @RequestParam int Id, Model model) {

        if (Id != 0) {
            ResponseEntity<Result<Credito>> responseGBId = restTemplate.exchange(baseUrl + "/CreditoService/CreditoById/" + Id,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<Result<Credito>>() {
            });

            Result<Credito> resultGBYId = responseGBId.getBody();

            model.addAttribute("Credito", resultGBYId.object);

        }

        return "FormCredito";

    }

    @PostMapping("/form")
    public String formulario(@ModelAttribute Credito credito) {

        if (credito.getId() == 0) {

            HttpEntity<Credito> HttpEntity = new HttpEntity(credito);

            ResponseEntity<Result<Credito>> responseAdd = restTemplate.exchange(baseUrl + "/CreditoService/Agregar",
                    HttpMethod.POST,
                    HttpEntity,
                    new ParameterizedTypeReference<Result<Credito>>() {
            });

            responseAdd.getStatusCode();

        } else {

            int Id = credito.getId();

            HttpEntity<Credito> HttpEntity = new HttpEntity(credito);
            ResponseEntity<Result<Credito>> responseUpdate = restTemplate.exchange(baseUrl + "/CreditoService/Actualizar?Id=" + Id,
                    HttpMethod.PUT,
                    HttpEntity,
                    new ParameterizedTypeReference<Result<Credito>>() {
            });
            responseUpdate.getStatusCode();
        }

        return "redirect:/Creditos";
    }

    @GetMapping("/Eliminar")
    public String Eliminar(@RequestParam int Id) {

        ResponseEntity<Result<Credito>> responseEliminar = restTemplate.exchange(baseUrl + "/CreditoService/Eliminar?Id=" + Id,
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result<Credito>>() {
        });
        responseEliminar.getStatusCode();

        return "redirect:/Creditos";
    }
    
    @GetMapping("/Grafics")
    public String Graficas(){
    
    return "Graficas";
    }
    
    

    @GetMapping("/TotalCreditos")
    @ResponseBody
    public ResponseEntity TCreditos(){

        ResponseEntity<Result> response = restTemplate.exchange(baseUrl + "/CreditoService/TCreditos",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<Result>(){});
        
        Result creditoT = response.getBody();
        
       
        return ResponseEntity.ok(creditoT);
    }
    
    
    

}
