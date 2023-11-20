package com.vapeshop.entity.address;

public class Province {
    private String provinceID;
    private String provinceName;

    public Province() {
    }

    public Province(String provinceID, String provinceName) {
        this.provinceID = provinceID;
        this.provinceName = provinceName;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceID='" + provinceID + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
