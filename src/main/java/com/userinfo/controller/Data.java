package com.userinfo.controller;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

private String ciphertext;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getCiphertext() {
return ciphertext;
}

public void setCiphertext(String ciphertext) {
this.ciphertext = ciphertext;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}