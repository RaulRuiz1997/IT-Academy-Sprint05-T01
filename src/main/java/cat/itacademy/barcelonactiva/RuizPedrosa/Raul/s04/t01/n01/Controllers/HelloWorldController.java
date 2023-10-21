package cat.itacademy.barcelonactiva.RuizPedrosa.Raul.s04.t01.n01.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloWorldController {


    /*
    El primer mètode respondrà a una petició GET, i haurà de ser configurat per a rebre el paràmetre com un RequestParam.
    El paràmetre "nom" tindrà el valor per defecte “UNKNOWN”.

    Haurà de respondre a:

    http://localhost:9000/HelloWorld
    http://localhost:9000/HelloWorld?nom=El meu nom
     */

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }

    /*
    El segon mètode respondrà a una petició GET, i haurà de ser configurat per a rebre el paràmetre com una PathVariable.
    El paràmetre "nom" serà opcional.

    Haurà de respondre a:

    http://localhost:9000/HelloWorld2
    http://localhost:9000/HelloWorld2/el meu nom
     */

    @GetMapping("/HelloWorld2/{nom}")
    public String saluda2(@PathVariable Optional<String> nom) {

        return nom.map(s -> "Hola, " + s + ". Estàs executant un projecte Maven").orElseGet(() -> "nom buit!");

    }

}
