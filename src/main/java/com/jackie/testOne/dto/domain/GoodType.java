package com.jackie.testOne.dto.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/2/14
 */
public class GoodType {
    private Long id;
    private String name;
    private int show;
    private int order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
