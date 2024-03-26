package org.test;

public class Line {

    private LineType lineType;
    private Service service;
    private Question question;
    private ResponseType responseType;
    private Date date;

    public Line(LineType lineType, Service service, Question question, ResponseType responseType, Date date) {
        this.lineType = lineType;
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
    }

    public LineType getLineType() {
        return lineType;
    }

    public void setLineType(LineType lineType) {
        this.lineType = lineType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineType=" + lineType +
                ", service=" + service +
                ", question=" + question +
                ", responseType=" + responseType +
                ", date=" + date +
                '}';
    }
}
