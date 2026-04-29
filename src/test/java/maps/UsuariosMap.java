package maps;

import java.util.HashMap;
import java.util.Map;

public class UsuariosMap {
    private static Map<String, Object> usuario;
    public static String idUsuario;

    public static Map<String, Object> getUsuario() {
        return usuario;
    }

    public static void initUsuario() {
        usuario = new HashMap<>();
        String timestamp = String.valueOf(System.currentTimeMillis());
        usuario.put("nome", "Fulano da Silva " + timestamp);
        usuario.put("email", "fulano" + timestamp + "@email.com");
        usuario.put("password", "123456");
        usuario.put("administrador", "true");
    }

}
