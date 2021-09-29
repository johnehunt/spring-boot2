package com.jjh.domain;

public class Coffee {

    private String brand;
    private String origin;
    private String characteristics;

    /**
     * Required zero parameter constructor
     */
    public Coffee() {}

    public Coffee(String brand, String origin, String characteristics) {
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coffee{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", origin='").append(origin).append('\'');
        sb.append(", characteristics='").append(characteristics).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
