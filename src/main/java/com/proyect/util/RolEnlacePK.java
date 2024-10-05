package com.proyect.util;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolEnlacePK implements Serializable {
    private Long idrol;
    private Long idenlace;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolEnlacePK)) return false;

        RolEnlacePK that = (RolEnlacePK) o;

        if (!idrol.equals(that.idrol)) return false;
        return idenlace.equals(that.idenlace);
    }

    @Override
    public int hashCode() {
        int result = idrol.hashCode();
        result = 31 * result + idenlace.hashCode();
        return result;
    }
}