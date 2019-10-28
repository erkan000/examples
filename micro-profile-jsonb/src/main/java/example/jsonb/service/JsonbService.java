package example.jsonb.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import javax.json.bind.config.PropertyOrderStrategy;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import example.jsonb.adapter.CarAdapter;
import example.jsonb.dto.Car;
import example.jsonb.dto.CustomizedCar;

@Path("rest")
public class JsonbService {

	@GET
	@Path("1")
	public String convertObjectToJSON() {
		Car car = new Car("BMW", "740i", LocalDate.now(), 1432l, false, BigDecimal.valueOf(123.4), 23.5d);
		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(car);
		Car serializedCar = jsonb.fromJson(resultJson, Car.class);
		return prettyPrint(resultJson, serializedCar);
	}

	@GET
	@Path("2")
	public String convertObjectArrayToJSON() {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("BMW", "740i", LocalDate.now(), 1432l, false, BigDecimal.valueOf(123.4), 23.5d);
		Car car2 = new Car("Mercedes", "S350", LocalDate.now(), 4321l, true, BigDecimal.valueOf(66.489), 1.5422d);
		cars.add(car1);
		cars.add(car2);
		
		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(cars);
		List<Car> serializedCars = jsonb.fromJson(resultJson, ArrayList.class.getClass().getGenericSuperclass());

		return prettyPrint(resultJson, serializedCars);
	}

	@GET
	@Path("3")
	public String convertObjectToJSONFormatInDTO() {
		CustomizedCar car = new CustomizedCar("BMW", "740i", LocalDate.now(), 1432l, false, BigDecimal.valueOf(123.4), 23.5d);

		Jsonb jsonb = JsonbBuilder.create();
		String resultJson = jsonb.toJson(car);
		
		return prettyPrint(resultJson,car);
	}


	@GET
	@Path("4")
	public String convertObjectToJSONwithConfig() {
		CustomizedCar car = new CustomizedCar("BMW", "740i", LocalDate.now(), 1432l, false, BigDecimal.valueOf(123.4), 23.5d);

		JsonbConfig config = new JsonbConfig()
				.withNullValues(false)
				.withFormatting(true)
				.withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL)
				.withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE_WITH_SPACES)
				.withDateFormat("YYYY-MM-dd", Locale.GERMAN);
		
		Jsonb jsonb = JsonbBuilder.create(config);
		String resultJson = jsonb.toJson(car);

		return prettyPrint(resultJson,car);
	}

	@GET
	@Path("5")
	public String convertObjectToJSONwithAdapter() {
		JsonbConfig config = new JsonbConfig()
				.withAdapters(new CarAdapter());
		
		CustomizedCar car = new CustomizedCar("BMW", "740i", LocalDate.now(), 1432l, false, BigDecimal.valueOf(123.4), 23.5d);
		
		Jsonb jsonb = JsonbBuilder.create(config);
		String jsonString = jsonb.toJson(car);
		
		return prettyPrint(jsonString,car);
	}

	private String prettyPrint(String json, Object serializedCar) {
		String newLine = "<br/>";
		StringBuilder b = new StringBuilder();
		b.append("JSON ");
		b.append(newLine);
		b.append(json); 				
		b.append(newLine);
		b.append(newLine);
		b.append("Object");
		b.append(newLine);
		b.append(serializedCar);
		return b.toString();
	}

}
