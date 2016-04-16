package ohtu;

public class Submission {

    private String student_number;
    private String week;
    private int hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean[] b;
    private int done = 0;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setB() {
        b = new boolean[12];
        b[0] = a1;
        b[1] = a2;
        b[2] = a3;
        b[3] = a4;
        b[4] = a5;
        b[5] = a6;
        b[6] = a7;
        b[7] = a8;
        b[8] = a9;
        b[9] = a10;
        b[10] = a11;
        b[11] = a12;
    }

    public String tasks() {
        String s = "";
        
        for (int i = 1; i <= b.length; i++) {
            if (b[i-1]) {
                s += " " + i + " ";
            }
        }
        return s;
    }

    public int getHours() {
        return hours;
    }

    public int getDone() {
        return done;
    }
    
    

    public void setDone() {
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                done++;
            }
        }
    }

    @Override
    public String toString() {
        return "viikko " + week + " tehtyjä tehtäviä yhteensä" + done + "aikaa kului " + hours + " tuntia, tehdyt tehtävät " + tasks();
    }

}
