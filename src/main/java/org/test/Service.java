package org.test;


public class Service {

    private Integer serviceId;
    private Integer variationId;
    private String asterisk;


    public Service(String serviceString) throws Exception {
        setIdsFromString(serviceString);
    }

    public void setIdsFromString(String serviceString) throws Exception {
        String[] segments = serviceString.split("\\.");

        if (segments.length > 2 || segments.length == 0) {
            throw new Exception("Invalid service id's number: " + segments.length);
        } else if(segments.length == 1){
            if(segments[0].equals("*")){
                asterisk = segments[0];
            } else {
                setServiceId(Integer.parseInt(segments[0]));
            }
        } else {
            setServiceId(Integer.parseInt(segments[0]));
            setVariationId(Integer.parseInt(segments[1]));
        }
    }

    public boolean isValid(Line line){
        if (serviceId != null && variationId != null){
            return serviceId.equals(line.getService().getServiceId()) && variationId.equals(line.getService().getVariationId());
        } else if(serviceId != null) {
            return serviceId.equals(line.getService().getServiceId());
        } else {
            return asterisk.equals("*");
        }
    }

    public Integer getServiceId() {
        if(asterisk != null){
            return 0;
        }
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getVariationId() {
        return variationId;
    }

    public void setVariationId(Integer variationId) {
        this.variationId = variationId;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", asterisk='" + asterisk + '\'' +
                '}';
    }
}
