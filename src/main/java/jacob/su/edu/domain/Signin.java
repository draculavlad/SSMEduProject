package jacob.su.edu.domain;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public class Signin {
    private int siginId;
    private int studentId;
    private int subjectId;

    public int getSiginId() {
        return siginId;
    }

    public void setSiginId(int siginId) {
        this.siginId = siginId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Signin{" +
            "siginId=" + siginId +
            ", studentId=" + studentId +
            ", subjectId=" + subjectId +
            '}';
    }
}
