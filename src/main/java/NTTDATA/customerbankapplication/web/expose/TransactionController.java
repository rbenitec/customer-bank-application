package NTTDATA.customerbankapplication.web.expose;

import NTTDATA.customerbankapplication.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Vamos a recibir los mensajes a nivel de la aplicacion
@RestController
public class TransactionController {

    @Autowired
    private KafkaProducer kafkaProducer;

    //
    @PostMapping("/customer/transaction")
    public ResponseEntity<String> sendTransaction(@RequestBody String transaction){
        kafkaProducer.publishMessage(transaction);
        return ResponseEntity.ok(transaction);
    }
}
