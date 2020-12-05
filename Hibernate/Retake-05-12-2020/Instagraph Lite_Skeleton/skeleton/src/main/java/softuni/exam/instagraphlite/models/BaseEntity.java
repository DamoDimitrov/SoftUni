package softuni.exam.instagraphlite.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private int id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
