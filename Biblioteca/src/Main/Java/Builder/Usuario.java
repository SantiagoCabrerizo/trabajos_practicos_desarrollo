package Main.Java.Builder;

public  class Usuario {
    private final String NombreUsuario;
    private  final String Direccion;

    private Usuario(Builder builder) {
        this.NombreUsuario = builder.NombreUsuario;
        this.Direccion = builder.Direccion;
    }

    public static class Builder {
        private String NombreUsuario;
        private String Direccion;

        //setters
        public void setNombreUsuario(String nombreUsuario) {
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


}
