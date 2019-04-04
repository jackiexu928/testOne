package com.jackie.testOne.service.read.impl;

import com.jackie.testOne.dto.domain.GoodInfo;
import com.jackie.testOne.dto.domain.GoodType;
import com.jackie.testOne.dto.request.BaseIdReqDTO;
import com.jackie.testOne.dto.response.AccountRespDTO;
import com.jackie.testOne.process.AbstractQueryService;
import com.jackie.testOne.process.Context;
import com.jackie.testOne.service.read.TestService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/8/31
 */
@Service
public class TestServiceImpl extends AbstractQueryService implements TestService {
    @Override
    public Context<BaseIdReqDTO, AccountRespDTO> test(BaseIdReqDTO baseIdReqDTO) {
        Context<BaseIdReqDTO, AccountRespDTO> context = new Context<>();
        if (baseIdReqDTO.getId().equals(1L)){
            AccountRespDTO accountRespDTO = new AccountRespDTO();
            accountRespDTO.setName("jackie");
            context.setResult(accountRespDTO);
            //context.setSuccess(true);
        }
        return context;
    }
}
