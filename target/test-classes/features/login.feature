Feature: Inicio de sesión de usuario

    Scenario: Acceso exitoso al sistema
        Given que el usuario visita la página de login
        When escribe su nombre "demoUser" y su clave "demoPass"
        Then debería ver el mensaje "Acceso concedido"