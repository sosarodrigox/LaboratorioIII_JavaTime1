import java.awt.EventQueue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FLocalDate extends JFrame {

	private JPanel contentPane;
	protected JPanel panel;
	protected JLabel lblNewLabel;
	protected JTextField txtFecha;
	protected JLabel lblFijoFechaCon;
	protected JTextField txtParse;
	protected JLabel lblFijoFechaCon_1;
	protected JTextField txtDateOf;
	protected JLabel lblNuevaFecha;
	protected JTextField txt5Dias;
	protected JLabel lblNuevaFecha_1;
	protected JTextField txt5Meses;
	protected JLabel lblLaFechaDe;
	protected JTextField txt_FechaHoy;
	protected JLabel lblDiferenciaDeDas;
	protected JTextField txtDifDias;
	protected JLabel lblDiferenciaDeMeses;
	protected JTextField txtDifMeses;
	protected JLabel lblFechaAnterior;
	protected JTextField txtFechaAnterior;
	protected JTextField txtBisiesto;
	protected JLabel lblAoBisiesto;
	protected JButton btnProcesar;
	protected JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FLocalDate frame = new FLocalDate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FLocalDate() {
		setTitle("FLocalDate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 414, 339);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Ingrese fecha en formato: dd/mm/aaaa ");
		lblNewLabel.setBounds(10, 11, 215, 14);
		panel.add(lblNewLabel);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(248, 8, 156, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		lblFijoFechaCon = new JLabel("Fijo fecha con PARSE:");
		lblFijoFechaCon.setBounds(10, 39, 215, 14);
		panel.add(lblFijoFechaCon);
		
		txtParse = new JTextField();
		txtParse.setColumns(10);
		txtParse.setBounds(248, 36, 156, 20);
		panel.add(txtParse);
		
		lblFijoFechaCon_1 = new JLabel("Fijo fecha con DateOf");
		lblFijoFechaCon_1.setBounds(10, 67, 215, 14);
		panel.add(lblFijoFechaCon_1);
		
		txtDateOf = new JTextField();
		txtDateOf.setColumns(10);
		txtDateOf.setBounds(248, 64, 156, 20);
		panel.add(txtDateOf);
		
		lblNuevaFecha = new JLabel("Nueva fecha +5 d\u00EDas: ");
		lblNuevaFecha.setBounds(10, 95, 215, 14);
		panel.add(lblNuevaFecha);
		
		txt5Dias = new JTextField();
		txt5Dias.setColumns(10);
		txt5Dias.setBounds(248, 92, 156, 20);
		panel.add(txt5Dias);
		
		lblNuevaFecha_1 = new JLabel("Nueva fecha +5 meses: ");
		lblNuevaFecha_1.setBounds(10, 123, 215, 14);
		panel.add(lblNuevaFecha_1);
		
		txt5Meses = new JTextField();
		txt5Meses.setColumns(10);
		txt5Meses.setBounds(248, 120, 156, 20);
		panel.add(txt5Meses);
		
		lblLaFechaDe = new JLabel("La fecha de hoy es:");
		lblLaFechaDe.setBounds(10, 151, 215, 14);
		panel.add(lblLaFechaDe);
		
		txt_FechaHoy = new JTextField();
		txt_FechaHoy.setColumns(10);
		txt_FechaHoy.setBounds(248, 148, 156, 20);
		panel.add(txt_FechaHoy);
		
		lblDiferenciaDeDas = new JLabel("Diferencia de d\u00EDas con fecha ingresada:");
		lblDiferenciaDeDas.setBounds(10, 179, 215, 14);
		panel.add(lblDiferenciaDeDas);
		
		txtDifDias = new JTextField();
		txtDifDias.setColumns(10);
		txtDifDias.setBounds(248, 176, 156, 20);
		panel.add(txtDifDias);
		
		lblDiferenciaDeMeses = new JLabel("Diferencia de meses con fecha ingresada:");
		lblDiferenciaDeMeses.setBounds(10, 207, 215, 14);
		panel.add(lblDiferenciaDeMeses);
		
		txtDifMeses = new JTextField();
		txtDifMeses.setColumns(10);
		txtDifMeses.setBounds(248, 204, 156, 20);
		panel.add(txtDifMeses);
		
		lblFechaAnterior = new JLabel("Fecha anterior:");
		lblFechaAnterior.setBounds(10, 250, 107, 14);
		panel.add(lblFechaAnterior);
		
		txtFechaAnterior = new JTextField();
		txtFechaAnterior.setColumns(10);
		txtFechaAnterior.setBounds(108, 247, 67, 20);
		panel.add(txtFechaAnterior);
		
		txtBisiesto = new JTextField();
		txtBisiesto.setColumns(10);
		txtBisiesto.setBounds(108, 275, 67, 20);
		panel.add(txtBisiesto);
		
		lblAoBisiesto = new JLabel("A\u00F1o bisiesto:");
		lblAoBisiesto.setBounds(10, 278, 107, 14);
		panel.add(lblAoBisiesto);
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//1) INGRESE FECHA EN FORMATO DD/MM/AAAA:
				//Genero el formateo para la fecha: (Lo uso para otros campos también)
				DateTimeFormatter dFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				//Uso el formateo y el Parse para tomar el dato del TextField txtFechaIngreso:
				LocalDate parseIngreso=LocalDate.parse(txtFecha.getText(),dFormat);
				
				//2) FIJO LA FECHA CON PARSE:
				txtParse.setText(parseIngreso.format(dFormat));
				
				//3) FIJO LA FECHA CON OF:
				// utilizo .of para generar una fecha a partir de sus partes ej:yy mm dd
				LocalDate fechaOf = LocalDate.of(parseIngreso.getYear(),parseIngreso.getMonth(),parseIngreso.getDayOfMonth());
				// Lleno el textfield utilizando dFormat y el LocalDate
				txtDateOf.setText(fechaOf.format(dFormat));
				
				//4) Nueva fecha +5 días:
				txt5Dias.setText(parseIngreso.plusDays(5).format(dFormat));
				
				//5) Nueva fecha +5 meses:
				txt5Meses.setText(parseIngreso.plusMonths(5).format(dFormat));
				
				//6) LA FECHA DE HOY ES:
				//Establezco la fecha actual:
				LocalDate fechaAhora = LocalDate.now();
				//Paso al TextField la fecha en el formateo "dFormat"
				txt_FechaHoy.setText(fechaAhora.format(dFormat));
				
				//7) DIFERENCIA DE DÍAS CON FECHA INGRESADA:
				// calculo dias long dias = DAYS.between(inicio, fin);
				// Importo: import static java.time.temporal.ChronoUnit.DAYS;
				
				Long difDias = Math.abs(DAYS.between(fechaAhora,parseIngreso));
				txtDifDias.setText(difDias.toString());
				
				//7) DIFERENCIA DE MESES CON FECHA INGRESADA:
				//Importo: import static java.time.temporal.ChronoUnit.MONTHS;
				Long difMeses = Math.abs(MONTHS.between(fechaAhora,parseIngreso));
				txtDifMeses.setText(difMeses.toString());
				
				//8) FECHA ANTERIOR:
				//Boolean: si una fechaes anterior a otra
				Boolean anterior = parseIngreso.isBefore(fechaAhora);
				txtFechaAnterior.setText(anterior.toString());
				
				//9) AÑO BISIESTO:
				//Boolean: el año es bisiesto
				Boolean bisiesto = parseIngreso.isLeapYear();
				txtBisiesto.setText(bisiesto.toString());
			}
		});
		btnProcesar.setBackground(Color.GREEN);
		btnProcesar.setBounds(248, 246, 156, 23);
		panel.add(btnProcesar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(248, 274, 156, 23);
		panel.add(btnSalir);
	}
}
