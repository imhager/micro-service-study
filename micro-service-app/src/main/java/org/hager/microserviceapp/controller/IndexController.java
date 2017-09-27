package org.hager.microserviceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: wzh
 * Date: 2017/9/27 16:10
 * Description:
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "/hi")
    public String hi() {
        return "hi,there.";
    }
}
