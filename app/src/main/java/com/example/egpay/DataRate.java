package com.example.egpay;


public class DataRate {

//    @SerializedName("id")
//    @Expose
    private Integer id;
//    @SerializedName("name")
//    @Expose
    private String name;
//    @SerializedName("required")
//    @Expose
    private String required;
//    @SerializedName("type")
//    @Expose
    private String type;
//    @SerializedName("default_value")
//    @Expose
    private Object defaultValue;
//    @SerializedName("multiple")
//    @Expose
    private String multiple;
//    @SerializedName("sort")
//    @Expose
    private Object sort;

    public DataRate(Integer id, String name, String required, String type, Object defaultValue, String multiple, Object sort) {
        this.id = id;
        this.name = name;
        this.required = required;
        this.type = type;
        this.defaultValue = defaultValue;
        this.multiple = multiple;
        this.sort = sort;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public Object getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

}