package com.example.demo1.controller;

import com.example.demo1.APIConstant;
import com.example.demo1.entity.SchemaVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryTheSchemaVersionController {

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/querySchema", method = RequestMethod.GET)
    public SchemaVersion querySchemaVersion() {
        return new SchemaVersion(APIConstant.SCHEMA_V1.replace("/", ""));
    }
}
