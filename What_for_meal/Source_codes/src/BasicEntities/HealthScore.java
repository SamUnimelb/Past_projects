package BasicEntities;

import java.util.Calendar;

public class HealthScore {

    private int rUserID;
    private double score;
    private Calendar recordTime;
    private String advice;

    public int getRUserID() {
        return this.rUserID;
    }

    /**
     *
     * @param rUserID
     */
    public void setRUserID(int rUserID) {
        this.rUserID = rUserID;
    }

    public double getScore() {
        return this.score;
    }

    /**
     *
     * @param score
     */
    public void setScore(double score) {
        this.score = score;
    }

    public Calendar getRecordTime() {
        return this.recordTime;
    }

    /**
     *
     * @param recordTime
     */
    public void setRecordTime(Calendar recordTime) {
        this.recordTime = recordTime;
    }

    public String getAdvice() {
        return this.advice;
    }

    /**
     *
     * @param advice
     */
    public void setAdvice(String advice) {
        this.advice = advice;
    }

}
