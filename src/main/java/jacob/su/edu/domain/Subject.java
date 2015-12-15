package jacob.su.edu.domain;

import java.util.Date;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author <a href="mailto:ysu2@cisco.com">Yu Su</a>
 * @version 1.0
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private Date created;
    private List<Teacher> teachers;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Subject{" +
            "subjectId=" + subjectId +
            ", subjectName='" + subjectName + '\'' +
            ", created=" + created +
            ", teachers=" + teachers +
            '}';
    }
}
