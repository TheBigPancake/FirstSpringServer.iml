package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiCarForm;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiCar
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:36
 * @Version TaxiCar: 1.0
 */
@Schema(description = "Car Entity")
public class TaxiCar implements DBDoced, NewTaxiElement{
    public int car_id;
    public String description;
    public CarType type;

    public TaxiCar(int car_id, String description, CarType type) {
        this.car_id = car_id;
        this.description = description;
        this.type = type;
    }
    private TaxiCar(Document doc){
        this.type = CarType.valueOf((String) doc.get("type"));
        this.description = (String) doc.get("description");
        this.car_id = (int) doc.get("car_id");
    }

    public TaxiCar(TaxiCarForm form)
    {
        this.car_id = Integer.parseInt(form.car_id);
        this.description = form.description;
        this.type = CarType.valueOf(form.type);
    }

    static public Object Create(Document doc){
        return new TaxiCar(doc);
    }

    @Override
    public Document getDoc()
    {
        Document doc = new Document();
        doc.append("car_id",this.car_id);
        doc.append("description",this.description);
        doc.append("type",this.type.toString());
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("car_id", this.car_id);
        return doc;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.car_id, ((TaxiCar)elem).car_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        return new TaxiCar(car_id, description, type);
    }

    @Override
    public String toHTML() {
        return "TaxiCar{" +
                "<br>car_id=" + car_id +
                ", <br>description='" + description +
                ", <br>type=" + type +
                "<br>}";
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
