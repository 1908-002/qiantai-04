package com.lkc.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider-shop")
public interface GouWuCheService {
}
