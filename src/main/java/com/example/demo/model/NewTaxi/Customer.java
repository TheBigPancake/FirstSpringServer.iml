package com.example.demo.model.NewTaxi;


import com.example.demo.model.NewTaxiForms.CustomerForm;
import com.example.demo.model.NewTaxiForms.FormatClass;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.Customer
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|21:31
 * @Version Customer: 1.0
 */
@Schema(description = "Customer Entity")
public class Customer implements DBDoced, NewTaxiElement{
    public int customer_id;
    public String full_name;
    public String phone;
    public boolean vip;

    public Customer(int customer_id, String full_name, String phone, boolean vip) {
        this.customer_id = customer_id;
        this.full_name = full_name;
        this.phone = phone;
        this.vip = vip;
    }

    public Customer(CustomerForm form)
    {
        if(form.vip==null)
            form.vip="off";
        this.customer_id = Integer.parseInt(form.customer_id);
        this.full_name = form.full_name;
        this.phone = form.phone;
        this.vip = form.vip.equals("on");
    }

    static public Object Create(Document doc){
        return new Customer((int) doc.get("customer_id"), (String) doc.get("full_name"), (String) doc.get("phone"),(boolean) doc.get("vip"));
    }

    @Override
    public Document getDoc()
    {
        Document doc = new Document();
        doc.append("customer_id",this.customer_id);
        doc.append("full_name",this.full_name);
        doc.append("phone",this.phone);
        doc.append("vip",this.vip);
        return doc;
    }

    @Override
    public Document setKey() {
        Document keys = new Document();
        keys.append("customer_id", this.customer_id);
        return keys;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.customer_id ,((Customer)elem).customer_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        return new Customer(customer_id, full_name, phone, vip);
    }

    @Override
    public String toHTML() {
        return "Customer{" +
                "<br>customer_id=" + customer_id +
                ", <br>full_name=" + full_name +
                ", <br>phone=" + phone +
                ", <br>vip=" + vip +
                "<br>}";
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }
}
