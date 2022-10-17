package com.statestr.datamanage.controler;

import com.statestr.datamanage.domain.ConvertMetadata;
import com.statestr.datamanage.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConvertController {

    @Autowired
    ConvertService convertService;
    @GetMapping("/csvToJson")
    @ResponseBody
    public String csvToJson(ConvertMetadata convertMetadata){

        return convertService.csvToJson(convertMetadata);
    }
}
