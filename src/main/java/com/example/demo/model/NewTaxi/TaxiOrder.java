package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiOperatorForm;
import com.example.demo.model.NewTaxiForms.TaxiOrderForm;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiOrdering
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:46
 * @Version TaxiOrdering: 1.0
 */
@Schema(description = "Order Entity")
public class TaxiOrder implements DBDoced, NewTaxiElement{
    public int order_id;
    public int customer_id;
    public int ride_id;
    public String phone;
    public String start_address;
    public String finish_address;
    public LocalDateTime date_of_ordering;
    public CarType car_type;
    public OrderStatus status;

    private TaxiOrder(int order_id, int customer_id, String phone, String start_address, String finish_address, CarType car_type) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.phone = phone;
        this.start_address = start_address;
        this.finish_address = finish_address;
        this.car_type = car_type;
        status = OrderStatus.waiting;
        date_of_ordering = LocalDateTime.now();
    }
    private TaxiOrder(Document doc){
        this.order_id = (int) doc.get("order_id");
        this.customer_id = (int) doc.get("customer_id");
        this.ride_id = (int) doc.get("ride_id");
        this.phone = (String) doc.get("phone");
        this.start_address = (String) doc.get("start_address");
        this.finish_address = (String) doc.get("finish_address");
        this.car_type = CarType.valueOf((String) doc.get("car_type"));
        this.status = OrderStatus.valueOf((String) doc.get("status"));
        this.date_of_ordering = ((Date) doc.get("date_of_ordering")).toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public TaxiOrder(TaxiOrderForm form)
    {
        this.order_id = Integer.parseInt(form.order_id);
        this.customer_id = Integer.parseInt(form.customer_id);
        this.ride_id = Integer.parseInt(form.ride_id);
        this.phone = form.phone;
        this.start_address = form.start_address;
        this.finish_address = form.finish_address;
        this.car_type = CarType.valueOf(form.car_type);
        this.status = OrderStatus.valueOf(form.status);
        this.date_of_ordering = LocalDateTime.parse(form.date_of_ordering);
    }

    static public TaxiOrder CreateOrder(int order_id, int customer_id, String phone, String start_address, String finish_address, CarType car_type)
    {
        return new TaxiOrder(order_id,customer_id,phone,start_address,finish_address,car_type);
    }

    static public Object Create(Document doc){
        return new TaxiOrder(doc);
    }
    @Override
    public Document getDoc() {

        Document doc = new Document();
        doc.append("order_id",this.order_id);
        doc.append("customer_id",this.customer_id);
        doc.append("ride_id",this.ride_id);
        doc.append("phone",this.phone);
        doc.append("start_address",this.start_address);
        doc.append("finish_address",this.finish_address);
        doc.append("date_of_ordering",this.date_of_ordering);
        doc.append("car_type",this.car_type.toString());
        doc.append("status",this.status.toString());
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("order_id", this.order_id);
        return doc;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.order_id, ((TaxiOrder)elem).order_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        TaxiOrder clone_order = new TaxiOrder(order_id, customer_id, phone, start_address, finish_address, car_type);
        clone_order.status = status;
        clone_order.date_of_ordering = date_of_ordering;
        return clone_order;
    }

    @Override
    public String toHTML() {
        return "TaxiOrder{" +
                "<br>order_id=" + order_id +
                ", <br>customer_id=" + customer_id +
                ", <br>phone='" + phone +
                ", <br>start_address='" + start_address +
                ", <br>finish_address='" + finish_address +
                ", <br>date_of_ordering=" + date_of_ordering +
                ", <br>car_type=" + car_type +
                ", <br>status=" + status +
                "<br>}";
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStart_address() {
        return start_address;
    }

    public void setStart_address(String start_address) {
        this.start_address = start_address;
    }

    public String getFinish_address() {
        return finish_address;
    }

    public void setFinish_address(String finish_address) {
        this.finish_address = finish_address;
    }

    public LocalDateTime getDate_of_ordering() {
        return date_of_ordering;
    }

    public void setDate_of_ordering(LocalDateTime date_of_ordering) {
        this.date_of_ordering = date_of_ordering;
    }

    public CarType getCar_type() {
        return car_type;
    }

    public void setCar_type(CarType car_type) {
        this.car_type = car_type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
