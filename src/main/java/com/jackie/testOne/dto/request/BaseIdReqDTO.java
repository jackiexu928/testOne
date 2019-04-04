package com.jackie.testOne.dto.request;

import com.jackie.testOne.dto.BaseReqDTO;
import com.jackie.testOne.util.ValidtionUitl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
public class BaseIdReqDTO extends BaseReqDTO {
    private Long id;
    @Override
    public void validation() {
        ValidtionUitl.validation(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
