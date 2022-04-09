package com.mark.springbootmarkopensource.bean.java8;


import lombok.Data;

@Data
public class Bar {
    private String name;
    private Integer count;

    public Double getTotalTypeValue() {
        return totalTypeValue;
    }

    public void setTotalTypeValue(Double totalTypeValue) {
        this.totalTypeValue = totalTypeValue;
    }

    private Double totalTypeValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private  String type;
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    private Integer money;
    //private List<Baz> bazList;

    public Bar() {
        this.name = null;
        this.type = null;
        this.count = 0;
        this.totalTypeValue = 0.0;
        this.money = 0;
        //this.bazList = Lists.newArrayList();
    }

    public Bar sum(Foo foo){
        if(name == null){
            this.name = foo.getName();
        }
        this.type = foo.getType();
        this.count += foo.getCount();
        this.totalTypeValue += foo.getTypeValue();
        this.money += foo.getMoney();
        //this.bazList.add(new Baz(foo.getType(),foo.getTypeValue()));
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name:").append(this.name).append(System.lineSeparator());
        sb.append("count:").append(this.count).append(System.lineSeparator());
        sb.append("totalTypeValue:").append(this.totalTypeValue).append(System.lineSeparator());
        sb.append("money:").append(this.money).append(System.lineSeparator());
        //sb.append("bazList:").append(System.lineSeparator());
        //this.bazList.forEach(baz->{
            //sb.append("\t").append("type:").append(baz.getType()).append(System.lineSeparator());
            //sb.append("\t").append("typeValue:").append(baz.getTypeValue()).append(System.lineSeparator());
        //});
        return sb.toString();
    }
}

