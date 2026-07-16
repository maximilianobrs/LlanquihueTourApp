package ui;

import interfaces.Registrable;
import model.*;
import data.*;
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
    private final JLabel lblClienteEdad = new JLabel("Edad:");
    private final JLabel lblClienteRut = new JLabel("Rut:");
    private final JLabel lblClienteTelefono = new JLabel("Telefono:");
    private final JLabel lblClienteCorreo = new JLabel("Correo:");

    private final JTextField tfClienteNombre = new JTextField();
    private final JTextField tfClienteEdad = new JTextField();
    private final JTextField tfClienteRut = new JTextField();
    private final JTextField tfClienteTelefono = new JTextField();
    private final JTextField tfClienteCorreo = new JTextField();

    private final JButton btnAgregarCliente = new JButton("Agregar Cliente");

    // ==================== Formulario Guia ====================

    private final JLabel lblNombre = new JLabel("Nombre:");
    private final JLabel lblEdad = new JLabel("Edad:");
    private final JLabel lblRut = new JLabel("Rut:");
    private final JLabel lblTelefono = new JLabel("Telefono:");
    private final JLabel lblCorreo = new JLabel("Correo:");
    private final JLabel lblFechaIngreso = new JLabel("Fecha de ingreso");
    private final JLabel lblIdioma = new JLabel("Idioma:");
    private final JLabel lblExperiencia = new JLabel("Experiencia:");

    private final JTextField tfNombre = new JTextField();
    private final JTextField tfEdad = new JTextField();
    private final JTextField tfRut = new JTextField();
    private final JTextField tfTelefono = new JTextField();
    private final JTextField tfCorreo = new JTextField();
    private final JTextField tfFechaIngreso = new JTextField();
    private final JTextField tfIdioma = new JTextField();
    private final JTextField tfExperiencia = new JTextField();

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
    private final JLabel lblDestinoTour = new JLabel("Destino: ");
    private final JLabel lblPrecioTour = new JLabel("Precio: ");

    private final JTextField tfNombreTour = new JTextField();
    private final JTextField tfDestinoTour = new JTextField();
    private final JTextField tfPrecioTour = new JTextField();

    private final JButton btnAgregarTour = new JButton("Agregar Tour");

    // ==================== Formulario Config tour ====================

    private final JComboBox<Tour> comboTours = new JComboBox<>();
    private final JComboBox<GuiaTuristico> comboGuias = new JComboBox<>();
    private final JComboBox<Vehiculo> comboVehiculo = new JComboBox<>();

    private final JLabel lblConfigTour = new JLabel("Tour: ");
    private final JLabel lblConfigGuia = new JLabel("Guia: ");
    private final JLabel lblConfigVehiculo = new JLabel("Vehiculo: ");

    private final JButton btnConfigTour = new JButton("Agregar configuracion");

    // ==================== Formulario incripcion tour ====================
    private final JComboBox<Cliente> comboInscripcionCliente = new JComboBox<>();
    private final JComboBox<Tour> comboInscripcionTour = new JComboBox<>();

    private final JLabel lblInscripcionCliente = new JLabel("Cliente: ");
    private final JLabel lblInscripcionTour = new JLabel("Tour: ");


    private final JButton btnGuardarInscripcion = new JButton("Inscripcion cliente");

    // ==================== Consola de salida ====================
    private final JTextArea txtConsola = new JTextArea();
    private final JScrollPane scrollConsola = new JScrollPane(txtConsola);

    // ==================== Panel inferior ====================
    private final JLabel lblTotalRegistros = new JLabel("Total registros: 0");
    private final JTextField tfTextoBuscar = new JTextField();
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
    private final JButton btnMostrarClientes = new JButton("Mostrar Clientes");
    private final JButton btnMostrarGuia = new JButton("Mostrar Guia");
    private final JButton btnMostrarTours = new JButton("Mostrar Tours");
    private final JButton btnMostrarVehiculo = new JButton("Mostrar Vehiculo");
    private final JButton btnSalir = new JButton("Salir");

    // ==================== Constructor ====================
    public MiVentana(GestorEntidades gestorCompartido) {
        // Paneles con layout inicial
        this.g = gestorCompartido;
        panelCliente = new JPanel(new GridLayout(6, 2, 8, 10));
        panelGuia = new JPanel(new GridLayout(9, 2, 8, 10));
        panelVehiculo = new JPanel(new GridLayout(5, 2, 8, 10));
        panelTour = new JPanel(new GridLayout(4,2,8,10));
        panelConfigTour = new JPanel(new GridLayout(4,2,8,10));
        panelInscripcion = new JPanel(new GridLayout(3,2,8,10));
        panelConsola = new JPanel(new BorderLayout());
        panelInferior = new JPanel(new GridLayout(1, 2, 10, 10));
        panelIzquierdo = new JPanel(new BorderLayout());
        panelBotonesNav = new JPanel(new GridLayout(12, 1, 15, 15));


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
        panelCliente.add(lblClienteEdad);
        panelCliente.add(tfClienteEdad);
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
        panelGuia.add(lblEdad);
        panelGuia.add(tfEdad);
        panelGuia.add(lblRut);
        panelGuia.add(tfRut);
        panelGuia.add(lblTelefono);
        panelGuia.add(tfTelefono);
        panelGuia.add(lblCorreo);
        panelGuia.add(tfCorreo);
        panelGuia.add(lblFechaIngreso);
        panelGuia.add(tfFechaIngreso);
        panelGuia.add(lblIdioma);
        panelGuia.add(tfIdioma);
        panelGuia.add(lblExperiencia);
        panelGuia.add(tfExperiencia);
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

    private void panelTour(){
        panelTour.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Registrar Tour"),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                )
        );

        panelTour.add(lblNombreTour);
        panelTour.add(tfNombreTour);
        panelTour.add(lblDestinoTour);
        panelTour.add(tfDestinoTour);
        panelTour.add(lblPrecioTour);
        panelTour.add(tfPrecioTour);
        panelTour.add(new JLabel());
        panelTour.add(btnAgregarTour);
    }

    private void panelConfigTour(){
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
        panelConfigTour.add(btnConfigTour);
    }

    private void panelInscripcion(){
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
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelInferior.add(lblTotalRegistros);
        panelInferior.add(new JLabel());
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

        panelBotonesNav.add(btnClientes);
        panelBotonesNav.add(btnGuias);
        panelBotonesNav.add(btnVehiculos);
        panelBotonesNav.add(btnTours);
        panelBotonesNav.add(btnConfigurarTour);
        panelBotonesNav.add(btnInscribirCliente);
        panelBotonesNav.add(btnMostrarRegistros);
        panelBotonesNav.add(btnMostrarClientes);
        panelBotonesNav.add(btnMostrarGuia);
        panelBotonesNav.add(btnMostrarTours);
        panelBotonesNav.add(btnMostrarVehiculo);
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
        btnConfigTour.addActionListener(e -> agregarConfigTour());

        btnClientes.addActionListener(e -> mostrarFormulario(panelCliente));
        btnGuias.addActionListener(e -> mostrarFormulario(panelGuia));
        btnVehiculos.addActionListener(e -> mostrarFormulario(panelVehiculo));
        btnTours.addActionListener(e -> mostrarFormulario(panelTour));
        btnInscribirCliente.addActionListener(e -> {
            actualizarCombos();
            mostrarFormulario(panelInscripcion);
        });

        btnConfigurarTour.addActionListener(e ->{
            actualizarCombos();
            mostrarFormulario(panelConfigTour);
        });

        btnMostrarRegistros.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.generarReporte();
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun registro.");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });

        btnMostrarClientes.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getClientes();
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun cliente registrado.");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });
        btnMostrarGuia.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getGuias();
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun guia registrado.");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });
        btnMostrarTours.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getTours();
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun tour registrado.");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });
        btnMostrarVehiculo.addActionListener(e -> {
            txtConsola.setText("");
            String datos = g.getVehiculos();
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun vehiculo registrado.");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });

        btnBuscar.addActionListener(e -> {
            txtConsola.setText("");
            String busqueda = tfTextoBuscar.getText().trim();
            if(busqueda.isEmpty()){
                JOptionPane.showMessageDialog(this, "Debe ingresar un parametro de busqueda.");
                return;
            }
            String datos = g.getBuscar(busqueda);
            if(datos.isEmpty()){
                JOptionPane.showMessageDialog(this, "No hay ningun registro de " + busqueda + ".");
                return;
            }
            txtConsola.append(datos);
            actualizarTotal();
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    // ==================== Lógica de negocio (handlers) ====================

    /**
     * Obtiene los datos ingresados desde la interfaz,
     * crea un objeto GuiaTuristico y lo registra en el gestor de entidades.
     * También actualiza la información mostrada en la consola gráfica.
     */
    private void agregarGuia() {
        try {

            String nombre = tfNombre.getText().trim();
            String edad = tfEdad.getText().trim();
            String rut = tfRut.getText().trim();
            String telefono = tfTelefono.getText().trim();
            String correo = tfCorreo.getText().trim();
            String fechaIngreso = tfFechaIngreso.getText().trim();
            String idioma = tfIdioma.getText().trim();
            String experiencia = tfExperiencia.getText().trim();

            if (nombre.isEmpty() || edad.isEmpty() || rut.isEmpty() || telefono.isEmpty() || correo.isEmpty() || fechaIngreso.isEmpty() || idioma.isEmpty() || experiencia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos del guía.");
                return;
            }

            int parseEdad = Integer.parseInt(edad);
            int parseExperiencia = Integer.parseInt(experiencia);

            if (parseEdad < 0){
                JOptionPane.showMessageDialog(this, "La edad debe ser mayor o igual a 0.");
                return;
            } else if (parseExperiencia < 0) {
                JOptionPane.showMessageDialog(this, "Los años de experiencia deben ser mayor o igual a 0.");
                return;
            }else if(!AppUtils.isValid(rut)){
                JOptionPane.showMessageDialog(this, "El rut es invalido.");
                return;
            } else if (!AppUtils.isValidMobile(telefono)) {
                JOptionPane.showMessageDialog(this, "El numero de telefono es invalido.");
                return;
            }else if (!AppUtils.isValidEmail(correo)){
                JOptionPane.showMessageDialog(this, "El correo es invalido.");
                return;
            }

            String codigoGuia = AppUtils.generarCodigo(g.getRecursos(), GuiaTuristico.class, "G");

            Contacto contacto = new Contacto(telefono, correo);
            GuiaTuristico nuevoGuia = new GuiaTuristico(nombre, parseEdad, rut, contacto, fechaIngreso, codigoGuia, idioma, parseExperiencia);

            String registroGuia = nuevoGuia.registrar();
            JOptionPane.showMessageDialog(this,registroGuia);
            g.registrarRecurso(nuevoGuia);

            tfNombre.setText("");
            tfEdad.setText("");
            tfRut.setText("");
            tfTelefono.setText("");
            tfCorreo.setText("");
            tfFechaIngreso.setText("");
            tfIdioma.setText("");
            tfExperiencia.setText("");

            actualizarTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.");
        }
    }

    /**
     * Obtiene los datos ingresados desde la interfaz,
     * crea un objeto Vehiculo y lo registra en el gestor de entidades.
     * Actualiza la visualización de registros después del ingreso.
     */
    private void agregarVehiculo() {
        try {
            String patente = tfPatente.getText().trim();
            String modelo = tfModelo.getText().trim();
            String capacidad = tfCapacidad.getText().trim();

            if (patente.isEmpty() || modelo.isEmpty() || capacidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos del vehículo.");
                return;
            }

            int parseCapacidad = Integer.parseInt(capacidad);

            if (parseCapacidad < 0){
                JOptionPane.showMessageDialog(this, "La capacidad debe ser mayor o igual a 0.");
                return;
            }

            String codigoVehiculo = AppUtils.generarCodigo(g.getRecursos(),Vehiculo.class,"V");
            Vehiculo nuevoVehiculo = new Vehiculo(codigoVehiculo, patente, modelo, parseCapacidad);

            String registroVehiculo = nuevoVehiculo.registrar();
            JOptionPane.showMessageDialog(this,registroVehiculo);
            g.registrarRecurso(nuevoVehiculo);

            tfPatente.setText("");
            tfModelo.setText("");
            tfCapacidad.setText("");

            actualizarTotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un número válido.");
        }
    }

    private void agregarCliente() {
        try {
            String nombre = tfClienteNombre.getText().trim();
            String edad = tfClienteEdad.getText().trim();
            String rut = tfClienteRut.getText().trim();
            String telefono = tfClienteTelefono.getText().trim();
            String correo = tfClienteCorreo.getText().trim();

            if (nombre.isEmpty() || edad.isEmpty() || rut.isEmpty()|| telefono.isEmpty()|| correo.isEmpty()){
                JOptionPane.showMessageDialog(this,"Complete todos los campos del Cliente.");
                return;
            }

            int parseEdad = Integer.parseInt(edad);

            if (parseEdad < 0){
                JOptionPane.showMessageDialog(this, "La edad debe ser mayor o igual a 0.");
                return;
            } else if (!AppUtils.isValid(rut)) {
                JOptionPane.showMessageDialog(this, "El rut es invalido.");
                return;
            } else if (!AppUtils.isValidMobile(telefono)) {
                JOptionPane.showMessageDialog(this, "El numero de telefono es invalido.");
                return;
            }else if (!AppUtils.isValidEmail(correo)){
                JOptionPane.showMessageDialog(this, "El correo es invalido.");
                return;
            }

            String codigoCliente = AppUtils.generarCodigo(g.getRecursos(),Cliente.class,"C");
            Contacto contactoCliente = new Contacto(telefono,correo);
            Cliente nuevoCliente = new Cliente(nombre,parseEdad,rut,contactoCliente,codigoCliente);

            String registroCliente = nuevoCliente.registrar();
            JOptionPane.showMessageDialog(this,registroCliente);
            g.registrarRecurso(nuevoCliente);

            tfClienteNombre.setText("");
            tfClienteEdad.setText("");
            tfClienteRut.setText("");
            tfClienteTelefono.setText("");
            tfClienteCorreo.setText("");

            actualizarTotal();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número válido.");
        }
    }


    private void agregarTour(){
        try{
            String nombre = tfNombreTour.getText().trim();
            String destino = tfDestinoTour.getText().trim();
            String precio = tfPrecioTour.getText().trim();

            if (nombre.isEmpty() || destino.isEmpty()|| precio.isEmpty()){
                JOptionPane.showMessageDialog(this,"Complete todos los campos del Tour.");
                return;
            }

            int parsePrecio = Integer.parseInt(precio);

            if (parsePrecio <= 0){
                JOptionPane.showMessageDialog(this,"El precio debe ser mayor a 0.");
                return;
            }

            String codigoTour = AppUtils.generarCodigo(g.getRecursos(),Tour.class,"T");
            Tour nuevoTour = new Tour(codigoTour,nombre,destino,parsePrecio);

            String registroTour = nuevoTour.registrar();
            JOptionPane.showMessageDialog(this, registroTour);
            g.registrarRecurso(nuevoTour);

            tfNombreTour.setText("");
            tfDestinoTour.setText("");
            tfPrecioTour.setText("");

            actualizarTotal();

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
        }
    }

    private void agregarConfigTour(){

    }

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
            } else if (r instanceof GuiaTuristico guia) {
                comboGuias.addItem(guia);
            } else if (r instanceof Vehiculo vehiculo) {
                comboVehiculo.addItem(vehiculo);
            } else if (r instanceof Cliente cliente) {
                comboInscripcionCliente.addItem(cliente);
            }
        }
    }

    // ==================== Utilidades privadas ====================

    private void mostrarFormulario(JPanel formulario) {
        panelFormularios.removeAll();
        panelFormularios.add(formulario, BorderLayout.CENTER);
        panelFormularios.revalidate();
        panelFormularios.repaint();
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