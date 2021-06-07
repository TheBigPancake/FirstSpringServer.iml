package com.example.demo.model.NewTaxiForms;

/**
 * Created by IntelliJ IDEA.
 * FirstSpringServer.iml.PageOrderForm
 *
 * @Autor: golde
 * @DateTime: 07.06.2021|9:02
 * @Version PageOrderForm: 1.0
 */
public class PageOrderForm  implements FormatClass{
    public String start_address;
    public String finish_address;
    public String phone;
    public String car_type;

    public PageOrderForm() {
    }

    public PageOrderForm(String start_address, String finish_address, String phone, String car_type) {
        this.start_address = start_address;
        this.finish_address = finish_address;
        this.phone = phone;
        this.car_type = car_type;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }
}
