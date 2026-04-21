package com.healthpod.suscription.rs;


import com.healthpod.suscription.model.Request;
import com.healthpod.suscription.model.Resultado;
import com.healthpod.suscription.svc.SuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suscription")
public class SuscriptionController {
    @Autowired
    SuscriptionService suscriptionService;

    @GetMapping("/conexion")
    public ResponseEntity<Resultado> testLogin() {
        return suscriptionService.testConexionSVC();
    }

    @PostMapping("/do/conexion")
    public ResponseEntity<Resultado> testLogin(Request request) {
        Resultado r=new Resultado();
        r.setMensaje(request.getMensaje());
        r.setRes(request.getCode());
        return ResponseEntity.ok(r);
    }
}
