package common.domain;

/**
 * Common domain class.
 */
public abstract class BaseDomain {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
