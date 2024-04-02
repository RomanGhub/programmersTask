package org.test;

public class Question {

    private Integer questionTypeId;
    private Integer categoryId;
    private Integer subcategoryId;
    private String asterisk;


    public Question(Integer questionTypeId, Integer categoryId, Integer subcategoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    public Question(String questionString) throws Exception {
        setIdsFromString(questionString);
    }

    public void setIdsFromString(String questionString) throws Exception {
        String[] segments = questionString.split("\\.");

        if (segments.length > 3 || segments.length == 0) {
            throw new Exception("Invalid question id's number: " + segments.length);
        } else if(segments.length == 1){
            if(segments[0].equals("*")){
                asterisk = segments[0];
            } else {
                setQuestionTypeId(Integer.parseInt(segments[0]));
            }
        } else if(segments.length == 2){
            setQuestionTypeId(Integer.parseInt(segments[0]));
            setCategoryId(Integer.parseInt(segments[1]));
        } else {
            setQuestionTypeId(Integer.parseInt(segments[0]));
            setCategoryId(Integer.parseInt(segments[1]));
            setSubcategoryId(Integer.parseInt(segments[2]));
        }
    }

    public boolean isValid(Line line){
        if(questionTypeId != null && categoryId != null && subcategoryId != null){
            return questionTypeId.equals(line.getQuestion().getQuestionTypeId())
                    && categoryId.equals(line.getQuestion().getCategoryId())
                    && subcategoryId.equals(line.getQuestion().getSubcategoryId());
        } else if (questionTypeId != null && categoryId != null){
            return questionTypeId.equals(line.getQuestion().getQuestionTypeId())
                    && categoryId.equals(line.getQuestion().getCategoryId());
        } else if(questionTypeId != null) {
            return questionTypeId.equals(line.getQuestion().getQuestionTypeId());
        }  else {
            return asterisk.equals("*");
        }
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
