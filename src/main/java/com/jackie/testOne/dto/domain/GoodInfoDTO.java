package com.jackie.testOne.dto.domain;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/2/14
 */
public class GoodInfoDTO {
    private String goodId;
    private String goodName;
    private double goodPrice;
    private String typeName;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
