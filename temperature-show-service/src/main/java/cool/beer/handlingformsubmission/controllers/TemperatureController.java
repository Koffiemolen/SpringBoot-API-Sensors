package cool.beer.handlingformsubmission.controllers;

import cool.beer.handlingformsubmission.models.TemperatureSummary;
import cool.beer.handlingformsubmission.models.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller

public class TemperatureController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getsensordata")
	public String sensorRequestForm(Model model) {
		model.addAttribute("sensor", new Temperature());
		return "sensor";
	}

	@PostMapping("/getsensordata")
	public String sensorSubmit(@ModelAttribute Temperature temperature, Model model) {
		System.out.println("sensorId = "+ temperature.getSensorId());
		String sensorId = temperature.getSensorId();

		System.out.println("requesting data: .....");
		TemperatureSummary temperatureSummary = restTemplate.getForObject("http://localhost:8091/temperatures/" + sensorId, TemperatureSummary.class);

		System.out.println("Data retrieved:");
		System.out.println(temperatureSummary.toString());
		Temperature temperature1 = new Temperature(temperature.getSensorId(), temperatureSummary.getAmbientTemperature(), temperatureSummary.getObjectTemperature());

		System.out.println("New temperature object created:");
		System.out.println(temperature1);

		model.addAttribute("sensor", temperature1);
		return "sensorresult";
	}

}
