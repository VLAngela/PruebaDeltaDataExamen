package com.AVazquez.PruebaDeltaData.DAO;

import com.AVazquez.PruebaDeltaData.ML.Credito;
import com.AVazquez.PruebaDeltaData.ML.CreditoPorMes;
import com.AVazquez.PruebaDeltaData.ML.CreditoRangos;
import com.AVazquez.PruebaDeltaData.ML.Result;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreditoDAOImplementation implements ICredito {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Result GetALLCreditos() {

        Result result = new Result();
        try {
            jdbcTemplate.execute("{CALL ListaCreditos(?)}",
                    (CallableStatementCallback<Integer>) callableStatement -> {
                        callableStatement.registerOutParameter(1, Types.REF_CURSOR);
                        callableStatement.execute();

                        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
                        result.objects = new ArrayList<>();
                        while (resultSet.next()) {

                            Credito credito = new Credito();

                            credito.setId(resultSet.getInt("id"));
                            credito.setCliente(resultSet.getNString("cliente"));
                            credito.setMonto(resultSet.getDouble("monto"));
                            credito.setTasa_interes(resultSet.getDouble("tasa_interes"));
                            credito.setPlazo(resultSet.getInt("plazo"));
                            credito.setFecha_otorgamiento(resultSet.getDate("fecha_otorgamiento"));

                            result.objects.add(credito);
                        }

                        return 1;
                    });
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }

        return result;
    }

    @Override
    public Result AddCreditos(Credito credito) {
        Result result = new Result();

        try {

            jdbcTemplate.execute("{CALL registroNuevoCredito(?,?,?,?,?)}",
                    (CallableStatementCallback<Integer>) callableStatement -> {

                        callableStatement.setString(1, credito.getCliente());
                        callableStatement.setDouble(2, credito.getMonto());
                        callableStatement.setDouble(3, credito.getTasa_interes());
                        callableStatement.setInt(4, credito.getPlazo());
                        callableStatement.setDate(5, new java.sql.Date(credito.getFecha_otorgamiento().getTime()));
                        callableStatement.execute();

                        return 1;
                    });
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }
        return result;
    }

    @Override
    public Result UpdateCreditos(Credito credito, int Id) {
        Result result = new Result();

        try {

            jdbcTemplate.execute("{CALL ActualizarCredito(?,?,?,?,?,?)}",
                    (CallableStatementCallback<Integer>) callableStatement -> {

                        callableStatement.setString(1, credito.getCliente());
                        callableStatement.setDouble(2, credito.getMonto());
                        callableStatement.setDouble(3, credito.getTasa_interes());
                        callableStatement.setInt(4, credito.getPlazo());
                        callableStatement.setDate(5, new java.sql.Date(credito.getFecha_otorgamiento().getTime()));
                        callableStatement.setInt(6, Id);
                        callableStatement.execute();

                        return 1;
                    });
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }
        return result;

    }

    @Override
    public Result DeleteCreditos(int Id) {
        Result result = new Result();

        try {
            jdbcTemplate.execute("{CALL EliminarCredito(?)}",
                    (CallableStatementCallback<Integer>) callableStatement -> {

                        callableStatement.setInt(1, Id);
                        callableStatement.execute();

                        return 1;
                    });
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }
        return result;
    }

    @Override
    public Result GetByIdCredito(int Id) {

        Result result = new Result();

        try {

            jdbcTemplate.execute("{CALL GetByIdCredito(?,?)}",
                    (CallableStatementCallback<Integer>) callableStatement -> {
                        callableStatement.setInt(1, Id);
                        callableStatement.registerOutParameter(2, Types.REF_CURSOR);
                        callableStatement.execute();

                        ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

                        if (resultSet.next()) {

                            Credito credito = new Credito();

                            credito.setId(resultSet.getInt("id"));
                            credito.setCliente(resultSet.getString("cliente"));
                            credito.setMonto(resultSet.getDouble("monto"));
                            credito.setTasa_interes(resultSet.getDouble("tasa_interes"));
                            credito.setPlazo(resultSet.getInt("plazo"));
                            credito.setFecha_otorgamiento(resultSet.getDate("fecha_otorgamiento"));

                            result.object = credito;
                        }

                        return 1;
                    });
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }
        return result;

    }

    @Override
    public Result Tcreditos() {

        Result result = new Result();
        try {

            jdbcTemplate.execute("{? = CALL obtener_creditos_por_mes}",
                    (CallableStatementCallback<Integer>) callableStatement -> {
                        callableStatement.registerOutParameter(1, Types.REF_CURSOR);
                        callableStatement.execute();
                        
                        result.objects = new ArrayList<>();
                                
                        ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
                       
                        while(resultSet.next()){
                            
                           
                        
                            String mes = resultSet.getString("mes");
                            int total = resultSet.getInt("total_creditos");
                         
                             CreditoPorMes cpm = new CreditoPorMes(mes, total);
                            
                            result.objects.add(cpm);
                        }

                        return 1;
                    });

            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;

        }

        return result;
    }

    @Override
    public Result RCreditos() {
        Result result = new Result();
        
        try{
            
            jdbcTemplate.execute("{? = CALL creditos_por_rango}",
                    (CallableStatementCallback<Integer>) callableStatement ->{
                    callableStatement.registerOutParameter(1, Types.REF_CURSOR);
                    callableStatement.execute();
                    
                    ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
                    
                    result.objects = new ArrayList<>();
                    while(resultSet.next()){
                    
                    String rango_monto = resultSet.getString("rango_monto");
                    int cantidad_creditos = resultSet.getInt("cantidad_creditos");
                    
                    CreditoRangos creRangos = new CreditoRangos(rango_monto, cantidad_creditos);
                    
                    result.objects.add(creRangos);
                    }
                    
                    
                    return 1;
                    });
            
            result.correct = true;
        
        }catch(Exception ex){
        result.correct = false;
            result.errorMesagge = ex.getLocalizedMessage();
            result.object = null;
            result.objects = null;
        
        }
        return result;
    }

}
