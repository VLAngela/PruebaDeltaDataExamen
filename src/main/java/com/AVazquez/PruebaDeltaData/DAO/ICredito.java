
package com.AVazquez.PruebaDeltaData.DAO;

import com.AVazquez.PruebaDeltaData.ML.Credito;
import com.AVazquez.PruebaDeltaData.ML.Result;


public interface ICredito {
    
    Result GetALLCreditos();
    Result AddCreditos(Credito credito);
    Result UpdateCreditos(Credito credito, int Id);
    Result DeleteCreditos(int Id);
    Result GetByIdCredito(int Id);
    
    Result Tcreditos();
   
}
