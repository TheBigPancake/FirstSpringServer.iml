package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiCarForm;
import com.example.demo.model.NewTaxiForms.TaxiDriverForm;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiDriver
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:37
 * @Version TaxiDriver: 1.0
 */
@Schema(description = "Driver Entity")
public class TaxiDriver  extends TaxiEmployee implements DBDoced, NewTaxiElement{
    public int driver_id;
    public int car_id;

    public TaxiDriver(String full_name, int driver_id, int car_id) {
        super(full_name);
        this.driver_id = driver_id;
        this.car_id = car_id;
    }
    private TaxiDriver(Document doc){
        super(doc);
        this.driver_id = (int) doc.get("driver_id");
        this.car_id = (int) doc.get("car_id");
    }

    public TaxiDriver(TaxiDriverForm form)
    {
        super(form.full_name);
        this.driver_id = Integer.parseInt(form.driver_id);
        this.car_id = Integer.parseInt(form.car_id);
        this.rating = Integer.parseInt(form.rating);
        this.work_hours_day = Integer.parseInt(form.work_hours_day);
        this.work_hours_night = Integer.parseInt(form.work_hours_night);
        this.premium = Integer.parseInt(form.premium);
    }

    static public Object Create(Document doc){
        return new TaxiDriver(doc);
    }
    @Override
    public Document getDoc() {

        Document doc = new Document();
        doc.append("driver_id",this.driver_id);
        doc.append("full_name",this.full_name);
        doc.append("car_id",this.car_id);
        doc.append("rating",this.rating);
        doc.append("premium",this.premium);
        doc.append("work_hours_day",this.work_hours_day);
        doc.append("work_hours_night",this.work_hours_night);
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("driver_id", this.driver_id);
        return doc;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.driver_id, ((TaxiDriver)elem).driver_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        TaxiDriver clone_driver = new TaxiDriver(full_name, driver_id, car_id);
        clone_driver.rating = this.rating;
        clone_driver.work_hours_day = this.work_hours_day;
        clone_driver.work_hours_night = this.work_hours_night;
        clone_driver.premium = this.premium;
        return clone_driver;
    }

    @Override
    public String toHTML() {
        return "TaxiDriver{" +
                "<br>driver_id=" + driver_id +
                ", <br>full_name='" + full_name +
                ", <br>car_id=" + car_id +
                ", <br>work_hours_day=" + work_hours_day +
                ", <br>work_hours_night=" + work_hours_night +
                ", <br>premium=" + premium +
                ", <br>rating=" + rating +
                "<br>}";
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
}
