package usmp.software.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ParentescoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "DNIEST", insertable = false, updatable = false)
    private Long DNIEST;

    @Column(name = "DNIPAD", insertable = false, updatable = false)
    private Long DNIPAD;

    public ParentescoPK() {
    }

    public Long getDNIEST() {
        return DNIEST;
    }

    public void setDNIEST(Long dNIEST) {
        DNIEST = dNIEST;
    }

    public Long getDNIPAD() {
        return DNIPAD;
    }

    public void setDNIPAD(Long dNIPAD) {
        DNIPAD = dNIPAD;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParentescoPK)) {
            return false;
        }
        ParentescoPK castOther = (ParentescoPK) other;
        return (this.DNIEST == castOther.DNIEST) && (this.DNIPAD == castOther.DNIPAD);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.DNIEST ^ (this.DNIEST >>> 32)));
        hash = hash * prime + ((int) (this.DNIPAD ^ (this.DNIPAD >>> 32)));
        return hash;
    }
    
}
