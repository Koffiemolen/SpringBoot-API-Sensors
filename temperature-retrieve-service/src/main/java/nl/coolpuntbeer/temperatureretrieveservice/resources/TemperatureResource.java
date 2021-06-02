package nl.coolpuntbeer.temperatureretrieveservice.resources;

import nl.coolpuntbeer.temperatureretrieveservice.models.Temperature;
import nl.coolpuntbeer.temperatureretrieveservice.models.TemperatureSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/temperatures")
public class TemperatureResource {

    @Value("${sensor.ipaddress}")
    private String ip;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{sensorId}")
    public Temperature getSensorData(@PathVariable("sensorId") String sensorId) {
        System.out.println("Url is:");
        System.out.println("http://" + ip + "/getTemperatures");
        TemperatureSummary temperatureSummary = restTemplate.getForObject("http://" + ip + "/getTemperatures", TemperatureSummary.class);
        return new Temperature(sensorId, temperatureSummary.getAmbientTemperature(), temperatureSummary.getObjectTemperature());

    }

}
