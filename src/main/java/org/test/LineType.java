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

    //TODO process exception here, make method private
    public void setTypeFromString(String lineString) throws Exception {
        //TODO remove redundant cast to arr and process it
        String[] typeSegment = lineString.split("\\.");

        if (typeSegment.length != 1) {
            throw new Exception("Invalid type of line");
        } else {
            setLineType(typeSegment[0]);
        }
    }

    public String getTypeAsString(){
        return type.toString();
    }

    @Override
    public String toString() {
        return "LineType{" +
                "type=" + type.tag +
                '}';
    }
}

