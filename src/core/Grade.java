package core;

public class Grade {
    private double lab;
    private double pTest;
    private double fTest;
    // cons
    public Grade (){
        // do nothing
    }
    public Grade (double lab , double pTest , double fTest){
        this.lab = lab;
        this.pTest = pTest;
        this.fTest = fTest;
    }
    // setter
    public void setLab(double lab) {
        if (lab < 0.0 || lab > 10.0){
            this.lab = 0;
        }
        else {
            this.lab = lab;
        }
    }
    public void setfTest(double fTest) {
        if (fTest < 0.0 || fTest > 10.0){
            this.lab = 0;
        }
        else {
            this.fTest = fTest;
        }
    }
    public void setpTest(double pTest) {
        if (pTest < 0.0 || pTest > 10.0){
            this.pTest = 0;
        }
        else {
            this.pTest = pTest;
        }
    }
    // getter
    public double getLab() {
        return lab;
    }
    public double getfTest() {
        return fTest;
    }
    public double getpTest() {
        return pTest;
    }
}
