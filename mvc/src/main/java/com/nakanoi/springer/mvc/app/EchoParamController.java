package com.nakanoi.springer.mvc.app;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller to echo request param. */
@Controller
@RequestMapping("/params")
public class EchoParamController {

  @GetMapping(params = "param")
  @ResponseBody
  public String echoParam(
      @RequestParam("param") String param,
      @RequestHeader(defaultValue = "Default Header") String echo) {
    return "[echoParam] Param: " + param + ", Echo Header: " + echo;
  }

  @GetMapping(consumes = "application/json")
  @ResponseBody
  public String echoParamWithJson(@RequestParam String paramWithJson) {
    return "[echoParamWithJson] param: " + paramWithJson;
  }

  @GetMapping(produces = "application/json")
  @ResponseBody
  public String echoParamWithAcceptHeader(@RequestParam String paramWithAccept) {
    return "[echoParamWithAcceptHeader] param: " + paramWithAccept;
  }

  @GetMapping(headers = "DateConvert")
  @ResponseBody
  public String echoDate(@RequestParam Date convertDate) {
    return "[echoDate] Date: " + convertDate;
  }

  @InitBinder("convertDate")
  public void initBinder(WebDataBinder binder) {
    binder.addCustomFormatter(new DateFormatter("yyyyMMdd"));
  }

  @GetMapping
  @ResponseBody
  public String echoDateAndNumber(
      @NumberFormat @RequestParam Integer number,
      @DateTimeFormat(pattern = "yyyyMMdd") @RequestParam Date date) {
    return "[echoDateAndNumber] Number: " + number + ", Date: " + date;
  }
}
