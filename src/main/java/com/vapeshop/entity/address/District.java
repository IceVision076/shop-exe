package com.vapeshop.entity.address;

public class District {
    private String districtId;
    private String districtName;

    public District() {
    }

    public District(String districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
