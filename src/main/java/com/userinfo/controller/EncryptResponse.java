package com.userinfo.controller;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



 @JsonIgnoreProperties(ignoreUnknown = true)
public class EncryptResponse {

private String requestId;
private String leaseId;
private Boolean renewable;
private Integer leaseDuration;
private Data data;
private Object wrapInfo;
private Object warnings;
private Object auth;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getRequestId() {
return requestId;
}

public void setRequestId(String requestId) {
this.requestId = requestId;
}

public String getLeaseId() {
return leaseId;
}

public void setLeaseId(String leaseId) {
this.leaseId = leaseId;
}

public Boolean getRenewable() {
return renewable;
}

public void setRenewable(Boolean renewable) {
this.renewable = renewable;
}

public Integer getLeaseDuration() {
return leaseDuration;
}

public void setLeaseDuration(Integer leaseDuration) {
this.leaseDuration = leaseDuration;
}

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

public Object getWrapInfo() {
return wrapInfo;
}

public void setWrapInfo(Object wrapInfo) {
this.wrapInfo = wrapInfo;
}

public Object getWarnings() {
return warnings;
}

public void setWarnings(Object warnings) {
this.warnings = warnings;
}

public Object getAuth() {
return auth;
}

public void setAuth(Object auth) {
this.auth = auth;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
} 
}