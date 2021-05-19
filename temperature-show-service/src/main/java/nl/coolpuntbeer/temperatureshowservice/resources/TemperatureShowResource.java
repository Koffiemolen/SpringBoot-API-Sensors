package nl.coolpuntbeer.temperatureshowservice.resources;


import nl.coolpuntbeer.temperatureshowservice.models.Temperature;
import nl.coolpuntbeer.temperatureshowservice.models.TemperatureSummary;
import nl.coolpuntbeer.temperatureshowservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/show")
public class TemperatureShowResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{sensorId}")
    public List<TemperatureSummary> getTemperatures(@PathVariable("sensorId") String sensorId){
        UserRating temperatureSummary = restTemplate.getForObject("http://TEMPERATURE-RETRIEVE-SERVICE/temperatures" + sensorId, UserRating.class );


        return temperatureSummary.getRatings().stream()
                .map(rating -> {
                    Temperature temp = rest
                })
    }
}
