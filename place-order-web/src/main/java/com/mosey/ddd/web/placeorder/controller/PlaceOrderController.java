package com.mosey.ddd.web.placeorder.controller;

import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderReqDTO;
import com.mosey.ddd.app.placeorder.sdk.param.CreateOrderResDTO;
import com.mosey.ddd.app.placeorder.sdk.service.PlaceOrderAppService;
import com.mosey.ddd.web.placeorder.res.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TangJie
 * @since 2023/4/17
 */
@RestController
@RequestMapping("/order")
public class PlaceOrderController{

    @Autowired
    private PlaceOrderAppService placeOrderAppService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/buy")
    public ApiResult<CreateOrderResDTO> buy(){
        return ApiResult.ok(placeOrderAppService.createOrder(buildReqDTO()));
    }

    /**
     * 构造前端参数
     * @return
     */
    private CreateOrderReqDTO buildReqDTO(){
        CreateOrderReqDTO createOrderReqDTO = new CreateOrderReqDTO();
        createOrderReqDTO.setBuyId(1L);
        createOrderReqDTO.setItemId(10001L);
        createOrderReqDTO.setQuantity(1);
        return createOrderReqDTO;
    }

}
