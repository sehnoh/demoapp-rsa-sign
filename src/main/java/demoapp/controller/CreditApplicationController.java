package demoapp.controller;

import demoapp.dto.RequestMessage;
import demoapp.dto.ResponseHeader;
import demoapp.dto.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class CreditApplicationController {

    @PostMapping(value = "/creditapplication",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseMessage creditApplication(@RequestBody @Valid RequestMessage message) {

        log.info("message={}", message);

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setHeader(new ResponseHeader(ResponseHeader.STATUS_SUCCESS));
        return responseMessage;
    }

}
