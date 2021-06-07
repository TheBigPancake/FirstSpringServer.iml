package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiOrderForm;
import com.example.demo.model.NewTaxiForms.TaxiRideForm;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiRide
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|21:54
 * @Version TaxiRide: 1.0
 */
@Schema(description = "Ride Entity")
public class TaxiRide implements DBDoced, NewTaxiElement{
    public int ride_id;
    public int car_id;
    public int driver_id;
    public LocalDateTime start_date;
    public LocalDateTime finish_date;
    public int waiting_time;
    public int km_by_city;
    public int km_outside_the_city;
    public PaymentType payment_type;
    public int donation;

    private TaxiRide(int ride_id, int car_id, int driver_id) {
        this.ride_id = ride_id;
        this.car_id = car_id;
        this.driver_id = driver_id;
        start_date = LocalDateTime.now();
    }
    private TaxiRide(Document doc) {
        this.ride_id = (int) doc.get("ride_id");
        this.car_id = (int) doc.get("car_id");
        this.driver_id = (int) doc.get("driver_id");

        this.start_date = ((Date) doc.get("start_date")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();;
        this.finish_date = ((Date) doc.get("finish_date")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();;

        this.waiting_time = (int) doc.get("waiting_time");
        this.km_by_city = (int) doc.get("km_by_city");
        this.km_outside_the_city = (int) doc.get("km_outside_the_city");
        this.payment_type = PaymentType.valueOf((String) doc.get("payment_type"));
        this.donation = (int) doc.get("donation");
    }

    public TaxiRide(TaxiRideForm form)
    {
        this.ride_id = Integer.parseInt(form.ride_id);
        this.car_id = Integer.parseInt(form.car_id);
        this.driver_id = Integer.parseInt(form.driver_id);
        this.start_date = LocalDateTime.parse(form.start_date);
        this.finish_date = LocalDateTime.parse(form.finish_date);
        this.waiting_time = Integer.parseInt(form.waiting_time);
        this.km_by_city = Integer.parseInt(form.km_by_city);
        this.km_outside_the_city = Integer.parseInt(form.km_outside_the_city);
        this.payment_type = PaymentType.valueOf(form.payment_type);
        this.donation = Integer.parseInt(form.donation);
    }

    public static TaxiRide startRide(int ride_id, int car_id, int driver_id)
    {
        return new TaxiRide(ride_id,car_id,driver_id);
    }
    public void endRide(PaymentType payment_type, int donation)
    {
        this.donation = donation;
        this.payment_type = payment_type;
        finish_date = LocalDateTime.now();
    }

    static public Object Create(Document doc){
        return new TaxiRide(doc);
    }
    @Override
    public Document getDoc() {

        Document doc = new Document();
        doc.append("ride_id",this.ride_id);
        doc.append("car_id",this.car_id);
        doc.append("driver_id",this.driver_id);
        doc.append("start_date",this.start_date);
        doc.append("finish_date",this.finish_date);
        doc.append("waiting_time",this.waiting_time);
        doc.append("km_by_city",this.km_by_city);
        doc.append("km_outside_the_city",this.km_outside_the_city);
        doc.append("payment_type",this.payment_type.toString());
        doc.append("donation",this.donation);
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("ride_id", this.ride_id);
        return doc;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.ride_id, ((TaxiRide)elem).ride_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        TaxiRide clone_ride = new TaxiRide(ride_id, car_id, driver_id);
        clone_ride.start_date = this.start_date;
        clone_ride.finish_date = this.finish_date;
        clone_ride.waiting_time = this.waiting_time;
        clone_ride.km_by_city = this.km_by_city;
        clone_ride.km_outside_the_city = this.km_outside_the_city;
        clone_ride.payment_type = this.payment_type;
        clone_ride.donation = this.donation;
        return clone_ride;
    }

    @Override
    public String toHTML() {
        return "TaxiRide{" +
                "<br>ride_id=" + ride_id +
                "<br>car_id=" + car_id +
                ", <br>driver_id=" + driver_id +
                ", <br>start_date=" + start_date +
                ", <br>finish_date=" + finish_date +
                ", <br>waiting_time=" + waiting_time +
                ", <br>km_by_city=" + km_by_city +
                ", <br>km_outside_the_city=" + km_outside_the_city +
                ", <br>payment_type=" + payment_type +
                ", <br>donation=" + donation +
                "<br>}";
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(LocalDateTime finish_date) {
        this.finish_date = finish_date;
    }

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time(int waiting_time) {
        this.waiting_time = waiting_time;
    }

    public int getKm_by_city() {
        return km_by_city;
    }

    public void setKm_by_city(int km_by_city) {
        this.km_by_city = km_by_city;
    }

    public int getKm_outside_the_city() {
        return km_outside_the_city;
    }

    public void setKm_outside_the_city(int km_outside_the_city) {
        this.km_outside_the_city = km_outside_the_city;
    }

    public PaymentType getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentType payment_type) {
        this.payment_type = payment_type;
    }

    public int getDonation() {
        return donation;
    }

    public void setDonation(int donation) {
        this.donation = donation;
    }
}
