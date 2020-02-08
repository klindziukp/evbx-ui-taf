package com.klindziuk.taf.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Config {

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("remoteDriverUrl")
    private String remoteDriverUrl;

    @JsonProperty("appUrl")
    private String appUrl;

    @JsonProperty("threadCount")
    private Integer threadCount;

    @JsonProperty("chromePath")
    private String chromePath;

    @JsonProperty("fireFoxPath")
    private String fireFoxPath;

    @JsonProperty("safariPath")
    private String safariPath;

    @JsonProperty("iePath")
    private String iePath;
}
