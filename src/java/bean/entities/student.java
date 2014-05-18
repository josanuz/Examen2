package bean.entities;

import java.io.Serializable;

public class student implements Serializable{
/*Constructors -------------------------------*/
    public student() {
        this.id = this.surName = this.name = "";
        this.thirdTest = this.secondTest = this.firstTest = 0.0f;
    }
    public student(String name, String surName, String id, float firstTest, float secondTest, float thirdTest) {
        this.name = name;
        this.surName = surName;
        this.id = id;
        this.firstTest = firstTest;
        this.secondTest = secondTest;
        this.thirdTest = thirdTest;
    }

/* Setters Getters ---------------------------*/
    public float getPromedio(){
        return (firstTest+secondTest+thirdTest)/3;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getFirstTest() {
        return firstTest;
    }

    public void setFirstTest(float firstTest) {
        this.firstTest = firstTest;
    }

    public float getSecondTest() {
        return secondTest;
    }

    public void setSecondTest(float secondTest) {
        this.secondTest = secondTest;
    }

    public float getThirdTest() {
        return thirdTest;
    }

    public void setThirdTest(float thirdTest) {
        this.thirdTest = thirdTest;
    }
/* Fields ----------------------------------------------------------- */
    private String name;
    private String surName;
    private String id;
    private float firstTest;
    private float secondTest;
    private float thirdTest;
}
