package org.test.entity;

public class ResponseType {

    private ResponseTypeEnum type;

    private enum ResponseTypeEnum {
        P("FIRST"),
        N("NEXT");

        private final String tag;

        ResponseTypeEnum(final String typeString) {
            this.tag = typeString;
        }
    }


    public ResponseType(String typeString) {
        setTypeFromString(typeString);
    }

    private void setTypeFromString(String lineString) {
        if (!lineString.equals("P") && !lineString.equals("N")) {
            throw new IllegalArgumentException("Invalid response type");
        } else {
            setType(lineString);
        }
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
