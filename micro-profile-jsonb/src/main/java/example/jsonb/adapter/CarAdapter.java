package example.jsonb.adapter;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

import example.jsonb.dto.Car;

public class CarAdapter implements JsonbAdapter<Car, JsonObject> {

    @Override
    public JsonObject adaptToJson(Car car) throws Exception {
        return Json.createObjectBuilder()
                .add("title", car.getBrand() + " - " + car.getModel())
                .add("creationDate", car.getProductionDate().toEpochDay())
                .add("price", car.getPrice().multiply(BigDecimal.valueOf(2l)))
                .build();
    }

    @Override
    public Car adaptFromJson(JsonObject jsonObject) throws Exception {
        Car car = new Car();
        car.setBrand(jsonObject.getString("title").split("-")[0].trim());
        car.setModel(jsonObject.getString("title").split("-")[1].trim());
        car.setReady(false);
        car.setPrice(BigDecimal.valueOf(jsonObject.getJsonNumber("price").longValue()));
        car.setProductionDate(LocalDate.ofEpochDay(jsonObject.getInt("creationDate")));
        return car;
    }
}
