package com.jackie.testOne.service.read;

import com.jackie.testOne.dto.request.BaseIdReqDTO;
import com.jackie.testOne.dto.response.AccountRespDTO;
import com.jackie.testOne.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/8/31
 */
public interface TestService {
    Context<BaseIdReqDTO, AccountRespDTO> test(BaseIdReqDTO baseIdReqDTO);
}
