package org.test;

public class ResponseType {

    private ResponseTypeEnum type;

    private enum ResponseTypeEnum{
        P("FIRST"),
        N("NEXT");

        private final String tag;

        ResponseTypeEnum(final String typeString) {
            this.tag = typeString;
        }
    }


    public ResponseType(String typeString) throws Exception {
        setTypeFromString(typeString);
    }

    public void setTypeFromString(String serviceString) throws Exception {
        String[] typeSegment = serviceString.split("\\.");

        if (typeSegment.length != 1) {
            throw new Exception("Invalid type");
        } else {
            setType(typeSegment[0]);
        }
    }

    public String getTypeAsString(){
        return type.toString();
    }

    public void setType(String type) {
        this.type = ResponseTypeEnum.valueOf(type);
    }

    @Override
    public String toString() {
        return "ResponseType{" +
                "type=" + type.tag +
                '}';
    }
}
