package com.jackie.testOne.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.testOne.dto.domain.GoodInfo;
import com.jackie.testOne.dto.domain.GoodType;
import com.jackie.testOne.dto.request.BaseIdReqDTO;
import com.jackie.testOne.service.read.GoodInfoMapper;
import com.jackie.testOne.service.read.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/8/31
 */
@RestController
@RequestMapping("test")
public class TestController extends BaseController {
    @Autowired
    private TestService testService;
    /*@Autowired
    private GoodInfoMapper goodInfoMapper;*/

    @RequestMapping(value = "/testOne",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String testOne(BaseIdReqDTO baseIdReqDTO){
        return toJSON(testService.test(baseIdReqDTO));
    }

    /*@RequestMapping(value = "/testMapStruct",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String testMapStruct(BaseIdReqDTO baseIdReqDTO){
        GoodInfo goodInfo = new GoodInfo();
        GoodType goodType = new GoodType();
        goodInfo.setId(1L);
        goodInfo.setTitle("aaa");
        goodInfo.setPrice(122);
        goodType.setName("hello mapStruct");
        return JSON.toJSONString(goodInfoMapper.fromGoodInfoDTO(goodInfo,goodType));
    }*/

}
