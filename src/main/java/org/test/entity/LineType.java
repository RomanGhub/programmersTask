package org.test.entity;


public class LineType {

    private LineTypeEnum type;

    private enum LineTypeEnum {
        C("WAITING_TIMELINE"),
        D("QUERY");

        private final String tag;

        LineTypeEnum(String tag) {
            this.tag = tag;
        }
    }


    public LineType(String typeString) {
        setTypeFromString(typeString);
    }

    public void setLineType(String typeString) {
        type = LineTypeEnum.valueOf(typeString);
    }

    private void setTypeFromString(String lineString) {
        if (!lineString.equals("C") && !lineString.equals("D")) {
            throw new IllegalArgumentException("Invalid type of line");
        } else {
            setLineType(lineString);
        }
    }

    public String getTypeAsString() {
        return type.toString();
    }

    @Override
    public String toString() {
        return "LineType{" +
                "type=" + type.tag +
                '}';
    }
}

