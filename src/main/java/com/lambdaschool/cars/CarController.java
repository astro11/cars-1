package com.lambdaschool.cars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CarController
{
    private final CarsRepository carsrepos;
    private final RabbitTemplate rt;

    public CarController(CarsRepository carsrepos, RabbitTemplate rt) {
        this.carsrepos = carsrepos;
        this.rt = rt;
    }


    // GET METHODS
    // returns all cars available
    @GetMapping("/cars")
    public List<Cars> all()
    {
        return carsrepos.findAll();
    }

    // returns the car based of id
    @GetMapping("/cars/id/{id}")
    public Cars findOne(@PathVariable Long id)
    {
        return carsrepos.findById(id).orElseThrow(() -> new CarsNotFoundException(id));
    }



    // returns a list of cars of that year model


    // returns a list of cars of that brand




    // POST METHODS
    @PostMapping("/cars/upload")
    public List<Cars> newCar(@RequestBody List<Cars> newCars)
    {
        log.info("Data Loaded!");
        return carsrepos.saveAll(newCars);
    }


    // DELETE METHODS
    // deletes a car from this list based off of the id
//    @DeleteMapping("/cars/delete/{id}")
//    public Cars findOne(@PathVariable Long id)
//    {
//        log.info("{id} " + " data deleted!");
//        carsrepos.deleteById(id);
//    }



//    @GetMapping("/cars/year")
//    public ObjectNode sumCars()
//    {
//        List<Cars> cars = carsrepos.findAll();
//
//        Long total = 0L;
//        for (Cars l : cars)
//        {
//            total = total + l.getYear();
//        }
//
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectNode totalYear = mapper.createObjectNode();
//        totalYear.put("id", 0);
//        totalYear.put("year", total);
//        totalYear.put("brand", "total");
//        totalYear.put("model", "total");
//        totalYear.put("comment", "Lambda");
//
////        MessageLog message = new MessageLog("Checked Total Year");
////        rt.convertAndSend(CarsApplication.QUEUE_NAME, message.toString());
////        log.info("Message sent!");
//        return totalYear;
    }




