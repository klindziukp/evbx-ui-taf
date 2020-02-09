package com.klindziuk.taf.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Captcha {

    @JsonProperty("userKey")
    private String userKey;

    @JsonProperty("googleKey")
    private String googleKey;

    @JsonProperty("captchaUrlPattern")
    private String captchaUrlPattern;

    @JsonProperty("tokenUrlPattern")
    private String tokenUrlPattern;
}
