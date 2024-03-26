package org.test;

public class Question {

    private Integer questionTypeId;
    private Integer categoryId;
    private Integer subcategoryId;


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
            setQuestionTypeId(Integer.parseInt(segments[0]));
        } else if(segments.length == 2){
            setQuestionTypeId(Integer.parseInt(segments[0]));
            setCategoryId(Integer.parseInt(segments[1]));
        } else {
            setQuestionTypeId(Integer.parseInt(segments[0]));
            setCategoryId(Integer.parseInt(segments[1]));
            setSubcategoryId(Integer.parseInt(segments[2]));
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
