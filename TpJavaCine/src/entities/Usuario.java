package entities;

public class Usuario {
		private String nombreUsuario;
		private String apellidoUsuario;
		private String email;
		private String pass;
		private String rol;
		private String estado;
		public String getNombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getApellidoUsuario() {
			return apellidoUsuario;
		}
		public void setApellidoUsuario(String apellidoUsuario) {
			this.apellidoUsuario = apellidoUsuario;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getRol() {
			return rol;
		}
		public void setRol(String rol) {
			this.rol = rol;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
}
