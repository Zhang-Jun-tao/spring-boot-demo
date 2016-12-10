package com.yx.statistics.model;

/**
 * Created by ZHANG on 2016/12/9.
 */
public class ConstantDictionary {
    private Integer id;
    private String code;
    private Integer type;
    private String description;
    private String relation_field_name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelation_field_name() {
        return relation_field_name;
    }

    public void setRelation_field_name(String relation_field_name) {
        this.relation_field_name = relation_field_name;
    }
}
