package ru.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "statistic-client", url = "${statistic-service.url}")
public interface StatisticClient {
    @RequestMapping(method = RequestMethod.POST, value = "/statistics")
    void sendStatistics(@RequestBody StatisticDto statisticDto);
}
