package com.AVazquez.PruebaDeltaData.RestController;

import com.AVazquez.PruebaDeltaData.DAO.CreditoDAOImplementation;
import com.AVazquez.PruebaDeltaData.ML.Credito;
import com.AVazquez.PruebaDeltaData.ML.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CreditoService")
public class CreditosRestController {

    Result result = new Result();

    @Autowired
    private CreditoDAOImplementation CreditoDAO;

    @GetMapping()
    public ResponseEntity GetAll() {

        Result result = CreditoDAO.GetALLCreditos();

        if (result.correct) {

            return ResponseEntity.ok().body(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }

    }

    @GetMapping("/CreditoById/{Id}")
    public ResponseEntity GetById(@PathVariable int Id) {

        Result resultGBId = CreditoDAO.GetByIdCredito(Id);

        if (resultGBId.correct) {

            return ResponseEntity.ok().body(resultGBId);
        } else {
            return ResponseEntity.badRequest().body(resultGBId);
        }
    }

    @PostMapping("/Agregar")
    public ResponseEntity Add(@RequestBody Credito credito) {

        Result resultAdd = CreditoDAO.AddCreditos(credito);

        if (resultAdd.correct) {

            return ResponseEntity.ok().body(resultAdd);

        } else {

            return ResponseEntity.ok().body(resultAdd);
        }

    }

    @PutMapping("/Actualizar")
    public ResponseEntity Update(@RequestBody Credito credito, @RequestParam int Id) {

        Result resultUpdate = CreditoDAO.UpdateCreditos(credito, Id);

        if (resultUpdate.correct) {

            return ResponseEntity.ok().body(resultUpdate);

        } else {
            return ResponseEntity.badRequest().body(resultUpdate);
        }
    }

    @DeleteMapping("/Eliminar")
    public ResponseEntity Delete(@RequestParam int Id) {

        Result resultDelete = CreditoDAO.DeleteCreditos(Id);

        if (resultDelete.correct) {

            return ResponseEntity.ok().body(resultDelete);
        } else {
            return ResponseEntity.badRequest().body(resultDelete);
        }

    }

    @GetMapping("/TCreditos")
    public ResponseEntity GetAllTCreditos() {

        Result resultTC = CreditoDAO.Tcreditos();
                
        if (resultTC.correct) {
            return ResponseEntity.ok().body(resultTC);
        }else{
            return ResponseEntity.badRequest().body(resultTC);
        }

    }

}
