package com.example.sion.studentm.JAVABeans;

public class Astudent extends BaseBean {
    @Override
    public String toString() {
        return "Astudent{" +
                "id=" + id +
                ", oneqi=" + oneqi +
                ", fourqi=" + fourqi +
                ", threeqi=" + threeqi +
                ", fiveqi=" + fiveqi +
                ", name='" + name + '\'' +
                ", twoqi=" + twoqi +
                ", stid=" + stid +
                '}';
    }

    /**
     * id : 124
     * oneqi : 12.5
     * fourqi : 0.0
     * threeqi : 0.0
     * fiveqi : 0.0
     * name : 梁浩文
     * twoqi : 0.0
     * stid : 1711605009
     */

    private int id;
    private double oneqi;
    private double fourqi;
    private double threeqi;
    private double fiveqi;
    private String name;
    private double twoqi;
    private int stid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOneqi() {
        return oneqi;
    }

    public void setOneqi(double oneqi) {
        this.oneqi = oneqi;
    }

    public double getFourqi() {
        return fourqi;
    }

    public void setFourqi(double fourqi) {
        this.fourqi = fourqi;
    }

    public double getThreeqi() {
        return threeqi;
    }

    public void setThreeqi(double threeqi) {
        this.threeqi = threeqi;
    }

    public double getFiveqi() {
        return fiveqi;
    }

    public void setFiveqi(double fiveqi) {
        this.fiveqi = fiveqi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTwoqi() {
        return twoqi;
    }

    public void setTwoqi(double twoqi) {
        this.twoqi = twoqi;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }
}
