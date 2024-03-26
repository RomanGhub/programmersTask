package org.test;


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

    public LineType(String typeString) throws Exception {
        setTypeFromString(typeString);
    }

    public void setLineType(String typeString) {
        type = LineTypeEnum.valueOf(typeString);
    }

    public void setTypeFromString(String lineString) throws Exception {
        String[] typeSegment = lineString.split("\\.");

        if (typeSegment.length != 1) {
            throw new Exception("Invalid type of line");
        } else {
            setLineType(typeSegment[0]);
        }
    }

    public LineTypeEnum getType(){
        return type;
    }
}

