package com.mark.controller;

import com.mark.bean.annotation.SemaphoreLimit;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @SemaphoreLimit(key = "call", limit = 5, blockingTime = 1)
    @RequestMapping(value="/hello/{id}",method= RequestMethod.GET)  //http://localhost:8080/myBoot/hello/23
    public String sayHello(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    @RequestMapping(value="/hello",method= RequestMethod.GET) //http://localhost:8080/myBoot/hello?id=23&name=xiaoming
    public String sayHello(@RequestParam("id") Integer id, @RequestParam("name") String name){
        return "id:"+id+ " name:"+name;
    }

    /*@PostMapping(value = "/testRedis")
    public R testRedis(HttpServletRequest request) {
        // 通过用户ID和访问IP，处理重复请求
        String key = userId + IPUtils.getIpAddr(request);
        Object redisKey = redisTemplate.opsForValue().get(key);
        System.out.println("redis值：" + redisKey);

        // redis中的key值存在则表示当前这次请求距离上一次请求不超过下面设置的三秒钟，直接返回即可
        if(redisKey != null){
            return R.ok("您的操作过快，请刷新重试");
        }

        Long count = redisTemplate.opsForValue().increment(key, 1); // 设置递增因子
        System.out.println("递增的值" + count);
        redisTemplate.expire(key, 3, TimeUnit.SECONDS); // 设置过期时间 3秒
        return R.ok("成功");
    }
*/

}