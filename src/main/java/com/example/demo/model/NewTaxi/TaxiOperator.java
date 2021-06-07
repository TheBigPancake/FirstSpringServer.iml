package com.example.demo.model.NewTaxi;

import com.example.demo.model.NewTaxiForms.TaxiDriverForm;
import com.example.demo.model.NewTaxiForms.TaxiOperatorForm;
import io.swagger.v3.oas.annotations.media.Schema;
import org.bson.Document;

/**
 * Created by IntelliJ IDEA.
 * Taxi.iml.TaxiOperator
 *
 * @Autor: golde
 * @DateTime: 24.03.2021|20:37
 * @Version TaxiOperator: 1.0
 */
@Schema(description = "Operator Entity")
public class TaxiOperator extends TaxiEmployee implements DBDoced, NewTaxiElement{
    public int operator_id;

    public TaxiOperator(String full_name, int operator_id) {
        super(full_name);
        this.operator_id = operator_id;
    }
    private TaxiOperator(Document doc){
        super(doc);
        this.operator_id = (int) doc.get("operator_id");
    }

    public TaxiOperator(TaxiOperatorForm form)
    {
        super(form.full_name);
        this.operator_id = Integer.parseInt(form.operator_id);
        this.rating = Integer.parseInt(form.rating);
        this.work_hours_day = Integer.parseInt(form.work_hours_day);
        this.work_hours_night = Integer.parseInt(form.work_hours_night);
        this.premium = Integer.parseInt(form.premium);
    }

    static public Object Create(Document doc){
        return new TaxiOperator(doc);
    }
    @Override
    public Document getDoc() {

        Document doc = new Document();
        doc.append("operator_id",this.operator_id);
        doc.append("full_name",this.full_name);
        doc.append("rating",this.rating);
        doc.append("work_hours_day",this.work_hours_day);
        doc.append("work_hours_night",this.work_hours_night);
        doc.append("premium",this.premium);
        return doc;
    }

    @Override
    public Document setKey() {
        Document doc = new Document();
        doc.append("operator_id", this.operator_id);
        return doc;
    }

    @Override
    public int compareTo(NewTaxiElement elem)
    {
        return Integer.compare(this.operator_id, ((TaxiOperator)elem).operator_id);
    }

    @Override
    public NewTaxiElement clone()
    {
        TaxiOperator clone_operator = new TaxiOperator(full_name, operator_id);
        clone_operator.rating = this.rating;
        clone_operator.work_hours_day = this.work_hours_day;
        clone_operator.work_hours_night = this.work_hours_night;
        clone_operator.premium = this.premium;
        return clone_operator;
    }

    @Override
    public String toHTML() {
        return "TaxiOperator{" +
                "<br>operator_id=" + operator_id +
                ", <br>full_name='" + full_name +
                ", <br>work_hours_day=" + work_hours_day +
                ", <br>work_hours_night=" + work_hours_night +
                ", <br>premium=" + premium +
                ", <br>rating=" + rating +
                "<br>}";
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }
}
