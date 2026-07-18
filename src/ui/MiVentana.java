package ui;

import interfaces.Registrable;
import model.*;
import data.*;
import exception.DatoEsInvalidoException;
import exception.RutEsInvalidoException;
import utils.AppUtils;

import javax.swing.*;
import java.awt.*;

public class MiVentana extends JFrame {


    // ==================== Datos ====================
    private final GestorEntidades g;
    private int totalRegistros = 0;

    // ==================== Paneles principales ====================
    private final JPanel panelCliente;
    private final JPanel panelGuia;
    private final JPanel panelVehiculo;
    private final JPanel panelTour;
    private final JPanel panelConfigTour;
    private final JPanel panelInscripcion;
    private final JPanel panelConsola;
    private final JPanel panelInferior;
    private final JPanel panelIzquierdo;

    private final JPanel panelFormularios;

    // ==================== Formulario Cliente ====================

    private final JLabel lblClienteNombre = new JLabel("Nombre:");
    private final JLabel lblClienteRut = new JLabel("Rut:");
    private final JLabel lblClienteTelefono = new JLabel("Telefono:");
    private final JLabel lblClienteCorreo = new JLabel("Correo:");

    private final JTextField tfClienteNombre = new JTextField();
    private final JTextField tfClienteRut = new JTextField();
    private final JTextField tfClienteTelefono = new JTextField();
    private final JTextField tfClienteCorreo = new JTextField();

    private final JButton btnAgregarCliente = new JButton("Agregar Cliente");

    // ==================== Formulario Guia ====================

    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JLabel lblRut = new JLabel("Rut:");
    private final JLabel lblTelefono = new JLabel("Telefono:");
    private final JLabel lblCorreo = new JLabel("Correo:");
    private final JLabel lblCargo = new JLabel("Cargo: ");
    private final JLabel lblIdioma = new JLabel("Idioma:");


    private final JTextField tfNombre = new JTextField();
    private final JTextField tfRut = new JTextField();
    private final JTextField tfTelefono = new JTextField();
    private final JTextField tfCorreo = new JTextField();
    private final JTextField tfCargo = new JTextField();
    private final JTextField tfIdioma = new JTextField();


    private final JButton btnAgregarGuia = new JButton("Agregar Guía");

    // ==================== Formulario Vehiculo ====================
    private final JLabel lblPatente = new JLabel("Patente:");
    private final JLabel lblModelo = new JLabel("Modelo:");
    private final JLabel lblCapacidad = new JLabel("Capacidad:");

    private final JTextField tfPatente = new JTextField();
    private final JTextField tfModelo = new JTextField();
    private final JTextField tfCapacidad = new JTextField();

    private final JButton btnAgregarVehiculo = new JButton("Agregar Vehículo");

    // ==================== Formulario Tour ====================
    private final JLabel lblNombreTour = new JLabel("Nombre: ");
    private final JLabel lblPrecioTour = new JLabel("Precio: ");

    private final JTextField tfNombreTour = new JTextField();
    private final JTextField tfPrecioTour = new JTextField();

    private final JButton btnAgregarTour = new JButton("Agregar Tour");

    // ==================== Formulario Config tour ====================

    private final JComboBox<Tour> comboTours = new JComboBox<>();
    private final JComboBox<GuiaTuristico> comboGuias = new JComboBox<>();
    private final JComboBox<Vehiculo> comboVehiculo = new JComboBox<>();

    private final JLabel lblConfigTour = new JLabel("Tour: ");
    private final JLabel lblConfigGuia = new JLabel("Guia: ");
    private final JLabel lblConfigVehiculo = new JLabel("Vehiculo: ");

    private final JButton btnGuardarConfig = new JButton("Guardar configuracion");

    // ==================== Formulario incripcion tour ====================
    private final JComboBox<Cliente> comboInscripcionCliente = new JComboBox<>();
    private final JComboBox<Tour> comboInscripcionTour = new JComboBox<>();

    private final JLabel lblInscripcionCliente = new JLabel("Cliente: ");
    private final JLabel lblInscripcionTour = new JLabel("Tour: ");


    private final JButton btnGuardarInscripcion = new JButton("Guardar Inscripción");

    // ==================== Consola de salida ====================
    private final JTextArea txtConsola = new JTextArea();
    private final JScrollPane scrollConsola = new JScrollPane(txtConsola);

    // ==================== Panel inferior ====================
    private final JLabel lblTotalRegistros = new JLabel("Total registros: 0");
    private final JTextField tfTextoBuscar = new JTextField();
    private final JComboBox<String> comboFiltroTipo = new JComboBox<>(
            new String[]{"Todos", "Cliente", "Guía", "Vehículo", "Tour"}
    );
    private final JButton btnBuscar = new JButton("Buscar");


    // ==================== Panel Izquierdo ====================
    private final JPanel panelBotonesNav;
    private final JButton btnGuias = new JButton("Registrar Guía");
    private final JButton btnVehiculos = new JButton("Registrar Vehículo");
    private final JButton btnClientes = new JButton("Registrar Cliente");
    private final JButton btnTours = new JButton("Registrar Tour");
    private final JButton btnConfigurarTour = new JButton("Configurar Tour");
    private final JButton btnInscribirCliente = new JButton("Inscribir Cliente");
    private final JButton btnMostrarRegistros = new JButton("Mostrar Registros");
    private final JButton btnSalir = new JButton("Salir");

    // ==================== Constructor ====================
    public MiVentana(GestorEntidades gestor) {

        this.g = gestor;

        // Paneles con layout inicial
        panelCliente = new JPanel(new GridLayout(5, 2, 8, 10));
        panelGuia = new JPanel(new GridLayout(7, 2, 8, 10));
        panelVehiculo = new JPanel(new GridLayout(5, 2, 8, 10));
        panelTour = new JPanel(new GridLayout(3, 2, 8, 10));
        panelConfigTour = new JPanel(new GridLayout(4, 2, 8, 10));
        panelInscripcion = new JPanel(new GridLayout(3, 2, 8, 10));
        panelConsola = new JPanel(new BorderLayout());
        panelInferior = new JPanel(new GridLayout(1, 2, 10, 10));
        panelIzquierdo = new JPanel(new BorderLayout());
        panelBotonesNav = new JPanel(new GridLayout(8, 1, 15, 15));


        panelFormularios = new JPanel(new BorderLayout());


        configurarVentana();
        panelCliente();
        panelGuia();
        panelVehiculo();
        panelTour();
        panelConfigTour();
        panelInscripcion();
        panelConsola();
        panelBotonesConsola();
        panelBotonesFormularios();
        ensamblarLayoutPrincipal();
        registrarEventos();

        mostrarFormulario(panelCliente);
    }

    // ==================== Configuración general del JFrame ====================
    private void configurarVentana() {
        setTitle("Llanquihue Tour");
        setSize(1000, 700);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    // ==================== Construcción de sub-paneles ====================
    private void panelCliente() {
        panelCliente.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Registrar Cliente"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );

        panelCliente.add(lblClienteNombre);
        panelCliente.add(tfClienteNombre);
        panelCliente.add(lblClienteRut);
        panelCliente.add(tfClienteRut);
        panelCliente.add(lblClienteTelefono);
        panelCliente.add(tfClienteTelefono);
        panelCliente.add(lblClienteCorreo);
        panelCliente.add(tfClienteCorreo);
        panelCliente.add(new JLabel());
        panelCliente.add(btnAgregarCliente);
    }

    private void panelGuia() {
        panelGuia.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Registrar Guía Turístico"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );


        panelGuia.add(lblNombre);
        panelGuia.add(tfNombre);
        panelGuia.add(lblRut);
        panelGuia.add(tfRut);
        panelGuia.add(lblTelefono);
        panelGuia.add(tfTelefono);
        panelGuia.add(lblCorreo);
        panelGuia.add(tfCorreo);
        panelGuia.add(lblCargo);
        panelGuia.add(tfCargo);
        panelGuia.add(lblIdioma);
        panelGuia.add(tfIdioma);
        panelGuia.add(new JLabel());
        panelGuia.add(btnAgregarGuia);
    }

    private void panelVehiculo() {
        panelVehiculo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Registrar Vehículo"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );

        panelVehiculo.add(lblPatente);
        panelVehiculo.add(tfPatente);
        panelVehiculo.add(lblModelo);
        panelVehiculo.add(tfModelo);
        panelVehiculo.add(lblCapacidad);
        panelVehiculo.add(tfCapacidad);
        panelVehiculo.add(new JLabel());
        panelVehiculo.add(btnAgregarVehiculo);
    }

    private void panelTour() {
        panelTour.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Registrar Tour"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );

        panelTour.add(lblNombreTour);
        panelTour.add(tfNombreTour);
        panelTour.add(lblPrecioTour);
        panelTour.add(tfPrecioTour);
        panelTour.add(new JLabel());
        panelTour.add(btnAgregarTour);
    }

    private void panelConfigTour() {
        panelConfigTour.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Configurar Tour"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );
        panelConfigTour.add(lblConfigTour);
        panelConfigTour.add(comboTours);
        panelConfigTour.add(lblConfigGuia);
        panelConfigTour.add(comboGuias);
        panelConfigTour.add(lblConfigVehiculo);
        panelConfigTour.add(comboVehiculo);
        panelConfigTour.add(new JLabel());
        panelConfigTour.add(btnGuardarConfig);
    }

    private void panelInscripcion() {
        panelInscripcion.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Configurar Tour"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );
        panelInscripcion.add(lblInscripcionCliente);
        panelInscripcion.add(comboInscripcionCliente);
        panelInscripcion.add(lblInscripcionTour);
        panelInscripcion.add(comboInscripcionTour);
        panelInscripcion.add(new JLabel());
        panelInscripcion.add(btnGuardarInscripcion);
    }

    private void panelConsola() {
        panelConsola.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Entidades Registradas"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );

        txtConsola.setEditable(false);
        txtConsola.setFocusable(false);
        txtConsola.setHighlighter(null);
        txtConsola.setCursor(Cursor.getDefaultCursor());
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 13));

        panelConsola.add(scrollConsola, BorderLayout.CENTER);
        panelConsola.add(panelInferior, BorderLayout.SOUTH);
    }

    private void panelBotonesConsola() {
        panelInferior.setLayout(new GridLayout(2, 2, 10, 10));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelInferior.add(lblTotalRegistros);
        panelInferior.add(comboFiltroTipo);
        panelInferior.add(tfTextoBuscar);
        panelInferior.add(btnBuscar);
    }

    private void panelBotonesFormularios() {
        panelIzquierdo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Panel botones"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );
        panelIzquierdo.setPreferredSize(new Dimension(180, 0));

        panelBotonesNav.setLayout(new GridLayout(8, 1, 15, 15));
        panelBotonesNav.add(btnClientes);
        panelBotonesNav.add(btnGuias);
        panelBotonesNav.add(btnVehiculos);
        panelBotonesNav.add(btnTours);
        panelBotonesNav.add(btnConfigurarTour);
        panelBotonesNav.add(btnInscribirCliente);
        panelBotonesNav.add(btnMostrarRegistros);
        panelBotonesNav.add(btnSalir);

        panelIzquierdo.add(panelBotonesNav, BorderLayout.NORTH);
    }

    // ==================== Ensamblado del layout principal ====================
    private void ensamblarLayoutPrincipal() {
        JPanel panelDerecho = new JPanel(new BorderLayout(10, 10));
        panelDerecho.add(panelFormularios, BorderLayout.NORTH);
        panelDerecho.add(panelConsola, BorderLayout.CENTER);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    // ==================== Eventos ====================
    private void registrarEventos() {
        btnAgregarCliente.addActionListener(e -> agregarCliente());
        btnAgregarGuia.addActionListener(e -> agregarGuia());
        btnAgregarVehiculo.addActionListener(e -> agregarVehiculo());
        btnAgregarTour.addActionListener(e -> agregarTour());

        btnGuardarConfig.addActionListener(e -> {
            agregarConfigTour();

            txtConsola.setText("");
            String datos = g.getBuscarPorTipo("Tour", null);
            txtConsola.append(datos);
        });
        btnGuardarInscripcion.addActionListener(e -> {
            inscripcionCliente();

            txtConsola.setText("");
            String datos = g.getBuscarPorTipo("Tour", null);
            txtConsola.append(datos);
        });

        btnClientes.addActionListener(e -> {
            txtConsola.setText("");
            mostrarFormulario(panelCliente);
        });
        btnGuias.addActionListener(e -> {
            txtConsola.setText("");
            mostrarFormulario(panelGuia);
        });
        btnVehiculos.addActionListener(e -> {
            txtConsola.setText("");
            mostrarFormulario(panelVehiculo);
        });
        btnTours.addActionListener(e -> {
            txtConsola.setText("");
            mostrarFormulario(panelTour);
        });

        btnInscribirCliente.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getBuscarPorTipo("Tour", null);
            txtConsola.append(datos);
            actualizarCombos();
            mostrarFormulario(panelInscripcion);
        });

        btnConfigurarTour.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getBuscarPorTipo("Tour", null);
            txtConsola.append(datos);
            actualizarCombos();
            mostrarFormulario(panelConfigTour);
        });

        btnMostrarRegistros.addActionListener(e -> {
            cargarRegistrosEnConsola();
            actualizarTotal();
        });

        btnBuscar.addActionListener(e -> {
            cargarBusquedaConsola();
            actualizarTotal();
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    // ==================== Lógica de negocio (handlers) ====================

    /**
     * Obtiene los datos ingresados desde la interfaz.
     * crea un objeto GuiaTuristico y lo registra en el gestor de entidades y los guarda en el txt.
     * También actualiza la información mostrada en la consola gráfica.
     */
    private void agregarGuia() {
        try {

            String nombre = tfNombre.getText().trim();
            String rut = tfRut.getText().trim().toUpperCase();
            String telefono = tfTelefono.getText().trim();
            String correo = tfCorreo.getText().trim().toLowerCase();
            String cargo = tfCargo.getText().trim().toLowerCase();
            String idioma = tfIdioma.getText().trim().toLowerCase();

            if (nombre.isEmpty() || rut.isEmpty() || telefono.isEmpty() || correo.isEmpty() || cargo.isEmpty() || idioma.isEmpty()) {
                throw new DatoEsInvalidoException("Complete todos los campos del guía.");
            }

            if (AppUtils.validarNombre(nombre)) {
                throw new DatoEsInvalidoException("Nombre invalido uso de solo letras de 2 a 60 caraccteres.");
            }

            if (!AppUtils.validarCargo(cargo)) {
                throw new DatoEsInvalidoException("Cargo invalido usar solo 3 y 50 carracteres\n" + "(Solo letras,espacio o hasta 2 numeros)");
            }
            if (!AppUtils.rutEsValido(rut)) {
                throw new RutEsInvalidoException("El rut es invalido.");
            }
            if (!AppUtils.mobilEsValido(telefono)) {
                throw new DatoEsInvalidoException("El numero de telefono es invalido solo numeros chilenos.");
            }

            if (!AppUtils.emailEsValido(correo)) {
                throw new DatoEsInvalidoException("El correo es invalido.");
            }

            int cantidad = g.contarPorTipo(GuiaTuristico.class);
            String codigoGuia = AppUtils.generarCodigo(cantidad, "G");

            Contacto contacto = new Contacto(telefono, correo);
            GuiaTuristico nuevoGuia = new GuiaTuristico(codigoGuia, nombre, rut, contacto, cargo, idioma);

            String registrar = g.registrarRecurso(nuevoGuia);
            g.guardarGuia();

            tfNombre.setText("");
            tfRut.setText("");
            tfTelefono.setText("");
            tfCorreo.setText("");
            tfCargo.setText("");
            tfIdioma.setText("");

            txtConsola.append(registrar);

            JOptionPane.showMessageDialog(this, nuevoGuia.registrar());
            actualizarTotal();
        } catch (RutEsInvalidoException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "El rut ingresado es inavalido");
        } catch (DatoEsInvalidoException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar el guía: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el guía: ");
        }
    }

    /**
     * Obtiene los datos ingresados desde la interfaz.
     * crea un objeto Vehiculo y lo registra en el gestor de entidades y los guarda en el txt.
     * También actualiza la información mostrada en la consola gráfica.
     */
    private void agregarVehiculo() {
        try {
            String patente = tfPatente.getText().trim().toUpperCase();
            String modelo = tfModelo.getText().trim().toUpperCase();
            String capacidad = tfCapacidad.getText().trim();

            if (patente.isEmpty() || modelo.isEmpty() || capacidad.isEmpty()) {
                throw new DatoEsInvalidoException("Complete todos los campos del vehículo.");
            }

            if (!AppUtils.patenteEsValida(patente)) {
                throw new DatoEsInvalidoException("La patente del vehiculo es invalida.\n" + "Formato valido: ABCD12, ABCD-12, AB-1234.");
            }
            if (!AppUtils.validarModelo(modelo)) {
                throw new DatoEsInvalidoException("Modelo invalido ingrese entre 2 y 30 caracteres.\n" + "solo letras, números, '.', o '-'");
            }
            int parseCapacidad = Integer.parseInt(capacidad);

            if (parseCapacidad <= 0 || parseCapacidad > 99) {
                throw new DatoEsInvalidoException("La capacidad debe ser mayor a 0 y menor a 100.");
            }

            int cantidad = g.contarPorTipo(Vehiculo.class);
            String codigoVehiculo = AppUtils.generarCodigo(cantidad, "V");
            Vehiculo nuevoVehiculo = new Vehiculo(codigoVehiculo, patente, modelo, parseCapacidad);

            tfPatente.setText("");
            tfModelo.setText("");
            tfCapacidad.setText("");

            String registro = g.registrarRecurso(nuevoVehiculo);
            g.guardarVehiculo();

            txtConsola.append(registro);

            JOptionPane.showMessageDialog(this, nuevoVehiculo.registrar());

            actualizarTotal();
        } catch (DatoEsInvalidoException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NumberFormatException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "La capacidad del vehiculo es un numero invalido.");
        }
    }

    /**
     * Obtiene los datos ingresados desde la interfaz.
     * crea un objeto Cliente y lo registra en el gestor de entidades y los guarda en el txt.
     * También actualiza la información mostrada en la consola gráfica.
     */
    private void agregarCliente() {
        try {
            String nombre = tfClienteNombre.getText().trim();
            String rut = tfClienteRut.getText().trim().toUpperCase();
            String telefono = tfClienteTelefono.getText().trim();
            String correo = tfClienteCorreo.getText().trim().toLowerCase();

            if (nombre.isEmpty() || rut.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
                throw new DatoEsInvalidoException("Complete todos los campos del Cliente.");
            }

            if (AppUtils.validarNombre(nombre)) {
                throw new DatoEsInvalidoException("Nombre invalido uso de solo letras y 2 a 60 caraccteres.");
            }

            if (!AppUtils.rutEsValido(rut)) {
                throw new RutEsInvalidoException("El rut ingresado es invalido.\n" + "Formato permitido: 12345678-9 o 12345678-K");
            }

            if (!AppUtils.mobilEsValido(telefono)) {
                throw new DatoEsInvalidoException("El numero de telefono es invalido solo numeros chilenos.");
            }
            if (!AppUtils.emailEsValido(correo)) {
                throw new DatoEsInvalidoException("El correo es invalido.");
            }
            if (g.existeRut(rut)) {
                throw new DatoEsInvalidoException("Ya existe una persona registrada con ese RUT.");
            }

            int cantidad = g.contarPorTipo(Cliente.class);
            String codigoCliente = AppUtils.generarCodigo(cantidad, "C");
            Contacto contactoCliente = new Contacto(telefono, correo);
            Cliente nuevoCliente = new Cliente(codigoCliente, nombre, rut, contactoCliente);

            tfClienteNombre.setText("");
            tfClienteRut.setText("");
            tfClienteTelefono.setText("");
            tfClienteCorreo.setText("");

            String registro = g.registrarRecurso(nuevoCliente);
            g.guardarCliente();

            txtConsola.append(registro);

            JOptionPane.showMessageDialog(this, nuevoCliente.registrar());
            actualizarTotal();

        } catch (RutEsInvalidoException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "El rut ingresado es inavalido");
        } catch (DatoEsInvalidoException e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, "Ocurrió un error al registrar el cliente.");
        }
    }

    /**
     * Obtiene los datos ingresados desde la interfaz
     * crea un objeto Tour y lo registra en el gestor de entidades y los guarda en el txt.
     * También actualiza la información mostrada en la consola gráfica.
     */
    private void agregarTour() {
        try {
            String nombre = tfNombreTour.getText().trim();
            String precio = tfPrecioTour.getText().trim();

            if (nombre.isEmpty() || precio.isEmpty()) {
                throw new DatoEsInvalidoException("Complete todos los campos del Tour.");
            }

            int parsePrecio = Integer.parseInt(precio);

            if (parsePrecio <= 0) {
                throw new DatoEsInvalidoException("El precio debe ser mayor a 0.");
            }

            int cantidad = g.contarPorTipo(Tour.class);
            String codigoTour = AppUtils.generarCodigo(cantidad, "T");
            Tour nuevoTour = new Tour(codigoTour, nombre, parsePrecio);

            tfNombreTour.setText("");
            tfPrecioTour.setText("");

            String registrar = g.registrarRecurso(nuevoTour);
            g.guardarTour();

            txtConsola.append(registrar);

            JOptionPane.showMessageDialog(this, nuevoTour.registrar());
            actualizarTotal();

        }catch (DatoEsInvalidoException e){
            txtConsola.append("Error: " + e.getMessage() + "\n");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
        }
    }

    /**
     * Obtiene los datos de los Jcombobox de tour,chiente.
     * Inscribe a un cliente a un tour seleccionado.
     */
    private void inscripcionCliente() {
            Tour selectTour = (Tour) comboInscripcionTour.getSelectedItem();
            Cliente selectCliente = (Cliente) comboInscripcionCliente.getSelectedItem();

            if (selectCliente == null || selectTour == null) {
                JOptionPane.showMessageDialog(this, "Se deben seleccionar todos los campos.");
                return;
            }

            if (selectTour.getClientes().contains(selectCliente)) {
                JOptionPane.showMessageDialog(this, "El cliente ya se encuentra inscrito en este tour.");
                return;
            }


            selectTour.getClientes().add(selectCliente);
            g.guardarTour();
            JOptionPane.showMessageDialog(this, "El cliente " + selectCliente.getNombre() + " inscrito correctamente.");
    }

    /**
     * Obtiene los datos de los Jcombobox de tour,guia,vehiculo.
     * Asigna al guia y al vehiculo a un tour en especifico.
     */
    private void agregarConfigTour() {


        Tour selectTour = (Tour) comboTours.getSelectedItem();
        GuiaTuristico selectGuia = (GuiaTuristico) comboGuias.getSelectedItem();
        Vehiculo selectVehiculo = (Vehiculo) comboVehiculo.getSelectedItem();

        if (selectTour == null || selectGuia == null || selectVehiculo == null) {
            JOptionPane.showMessageDialog(this, "Se deben seleccionar todos los campos.");
            return;
        }

        selectTour.setGuiaTuristico(selectGuia);
        selectTour.setVehiculo(selectVehiculo);
        g.guardarTour();
        JOptionPane.showMessageDialog(this, "Configuración de " + selectTour.getNombre() + " actualizada correctamente.");
    }

    /**
     * Renellena los campos de los Jcombobox con la inforamcion de la agencia
     */
    private void actualizarCombos() {
        comboTours.removeAllItems();
        comboInscripcionTour.removeAllItems();
        comboGuias.removeAllItems();
        comboVehiculo.removeAllItems();
        comboInscripcionCliente.removeAllItems();


        for (Registrable r : g.getRecursos()) {
            if (r instanceof Tour tour) {
                comboTours.addItem(tour);
                comboInscripcionTour.addItem(tour);
            }

            if (r instanceof GuiaTuristico guia) {
                comboGuias.addItem(guia);
            }

            if (r instanceof Vehiculo vehiculo) {
                comboVehiculo.addItem(vehiculo);
            }

            if (r instanceof Cliente cliente) {
                comboInscripcionCliente.addItem(cliente);
            }
        }
    }

    // ==================== Utilidades privadas ====================

    private void cargarRegistrosEnConsola() {
        txtConsola.setText("");
        String datos = g.generarReporte();
        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun registro.");
            return;
        }
        txtConsola.append(datos);
    }

    /**
     * metodo encargado de ver que formulario se mostrara en la ventana.
     *
     * @param formulario recibe como parametro el formulario que estara a la vista
     */
    private void mostrarFormulario(JPanel formulario) {
        panelFormularios.removeAll();
        panelFormularios.add(formulario, BorderLayout.CENTER);
        panelFormularios.revalidate();
        panelFormularios.repaint();
    }

    /**
     * Filtra los recursos registrados según el tipo seleccionado en el combo
     * de filtro y, opcionalmente, un texto de búsqueda ingresado por el usuario.
     * Limpia la consola y muestra los resultados encontrados, o un mensaje
     * si no hay coincidencias.
     */
    private void cargarBusquedaConsola() {
        txtConsola.setText("");
        String tipo = (String) comboFiltroTipo.getSelectedItem();
        String busqueda = tfTextoBuscar.getText().trim();

        String datos = g.getBuscarPorTipo(tipo, busqueda);
        if (datos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron registros para ese filtro.");
            return;
        }
        txtConsola.append(datos);
    }

    /**
     * Actualiza el contador visual de registros existentes
     * en la colección administrada por GestorEntidades.
     */
    private void actualizarTotal() {
        totalRegistros = g.getRecursos().size();
        lblTotalRegistros.setText("Total registros: " + totalRegistros);
    }
}