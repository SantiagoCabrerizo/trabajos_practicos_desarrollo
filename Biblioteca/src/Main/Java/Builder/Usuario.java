package Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Usuario {
    private String nombreUsuario;
    private String direccion;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;


    private Usuario(Builder builder) {
        this.nombreUsuario = builder.nombreUsuario;
        this.direccion = builder.direccion;
        this.email = builder.email;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }

    public static class Builder {
        private String nombreUsuario;
        private String direccion;
        private String email;
        private String telefono;
        private LocalDate fechaNacimiento;
        public Builder setNombreUsuario (String name) {this.nombreUsuario = name; return this;}
        public Builder setDireccion (String address) {this.direccion = address; return this;}
        public Builder setEmail (String mail) {this.email = mail; return this;}
        public Builder setTelefono (String number) {this.telefono = number; return this;}
        public Builder setFechaNacimiento (LocalDate fechNac) {this.fechaNacimiento = fechNac; return this;}
        public Usuario build(){
            return new Usuario(this);
        }
    }

        //setters
        /*public void setNombreUsuario(String nombreUsuario) {
            NombreUsuario = nombreUsuario;
        }

        public void setDireccion(String direccion) {
            Direccion = direccion;
        }


        public Usuario build() {
            return new Usuario(this);
        }
    }
        @Override
    public String toString(){
        return "Usuario: "+ NombreUsuario + " Dirección: "+ Direccion;
        }
        */


}

