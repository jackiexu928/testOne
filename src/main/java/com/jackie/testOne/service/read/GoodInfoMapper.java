package com.jackie.testOne.service.read;

import com.jackie.testOne.dto.domain.GoodInfo;
import com.jackie.testOne.dto.domain.GoodInfoDTO;
import com.jackie.testOne.dto.domain.GoodType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2019/2/14
 */
//@Mapper(componentModel = "spring")
public interface GoodInfoMapper {
    @Mappings({
            @Mapping(source = "type.name",target = "typeName"),
            @Mapping(source = "good.id",target = "goodId"),
            @Mapping(source = "good.title",target = "goodName"),
            @Mapping(source = "good.price",target = "goodPrice")
    })
    GoodInfoDTO fromGoodInfoDTO(GoodInfo good, GoodType type);
}
