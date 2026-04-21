package com.healthpod.suscription.svc;

import com.healthpod.suscription.model.Resultado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SuscriptionService {

    @Value("${app.developer}")
    private String developer;
    private final JdbcTemplate jdbcTemplate;

    public SuscriptionService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public ResponseEntity<Resultado> testConexionSVC() {

        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        Resultado res=new Resultado();
        res.setRes("0");
        res.setMensaje("QUERY: "+result+" CONFIGMAP: "+developer);

        return ResponseEntity.ok(res);
    }
}
