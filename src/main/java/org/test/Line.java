package org.test;

import java.util.Objects;

public class Line {

    private LineType lineType;
    private Service service;
    private Question question;
    private ResponseType responseType;
    private Date date;
    private Integer timeInMinutes;


    public Line(LineType lineType, Service service, Question question, ResponseType responseType, Date date, String time) {
        this.lineType = lineType;
        this.service = service;
        this.question = question;
        this.responseType = responseType;
        this.date = date;
        if(time != null) this.timeInMinutes =  Integer.valueOf(time);
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

    public Integer getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(Integer timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lineType, line.lineType) && Objects.equals(service, line.service) && Objects.equals(question, line.question) && Objects.equals(responseType, line.responseType) && Objects.equals(date, line.date) && Objects.equals(timeInMinutes, line.timeInMinutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineType, service, question, responseType, date, timeInMinutes);
    }

    public boolean isValid(Line line){
        return this.service.isValid(line) && this.question.isValid(line);
    }
}
