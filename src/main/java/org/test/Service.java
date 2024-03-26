package org.test;

public class Service {

    private Integer serviceId;
    private Integer variationId;

    public Service(Integer serviceId, Integer variationId) {
        this.serviceId = serviceId;
        this.variationId = variationId;
    }

    public Service(String serviceString) throws Exception {
        setIdsFromString(serviceString);
    }

    public void setIdsFromString(String serviceString) throws Exception {
        String[] segments = serviceString.split("\\.");

        if (segments.length > 2 || segments.length == 0) {
            throw new Exception("Invalid service id's number: " + segments.length);
        } else if(segments.length == 1){
            setServiceId(Integer.parseInt(segments[0]));
        } else {
            setServiceId(Integer.parseInt(segments[0]));
            setVariationId(Integer.parseInt(segments[1]));
        }
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Object getVariationId() {
        return variationId;
    }

    public void setVariationId(Integer variationId) {
        this.variationId = variationId;
    }
}
