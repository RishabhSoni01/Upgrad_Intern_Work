
public class Patient extends User {

    private long patientId;
    private boolean insured;

    public long getPatientId() {
        return patientId;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}