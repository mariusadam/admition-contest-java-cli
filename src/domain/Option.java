package domain;

/**
 * Created by marius on 10/13/16.
 */
public class Option extends Entity {
    private Candidate candidate;
    private Department department;

    /**
     *
     * @param id         The unique id identifying an entity
     * @param candidate  The candidate
     * @param department The department
     */
    public Option(Integer id, Candidate candidate, Department department) {
        super(id);
        this.candidate = candidate;
        this.department = department;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toCsvFormat() {
        return String.format("%s,%s,%s", id.toString(), candidate.getId().toString(), department.getId().toString());
    }

    @Override
    public Option clone() throws CloneNotSupportedException {
        Option cloned     = (Option) super.clone();
        cloned.candidate  = this.candidate;
        cloned.department = this.department;

        return cloned;
    }
}
