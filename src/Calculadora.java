import java.awt.*;
import java.awt.event.*;

public class Calculadora extends Frame implements ActionListener {

    TextField txtNumero;
    Button btnSomar, btnSubtrair, btnDividir, btnMultiplicar, btnIgual, btnPonto, btnC;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

    double num1 = 0, num2 = 0;
    String operador = "";

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 600);
        setLayout(new BorderLayout(10, 10)); // Layout principal
        setVisible(true);

        Panel painelTopo = new Panel(new BorderLayout());

        //campo de texto para mostrar os números
        txtNumero = new TextField(20);
        txtNumero.setPreferredSize(new Dimension(300, 50)); //definir a dimensão do botão largura x altura
        painelTopo.add(txtNumero, BorderLayout.CENTER);

        //botão pra limpar o texto
        btnC = new Button("C");
        btnC.setPreferredSize(new Dimension(80, 50));
        painelTopo.add(btnC, BorderLayout.EAST);
        btnC.addActionListener(this);

        add(painelTopo, BorderLayout.NORTH);

        //painel para os botões
        Panel painel = new Panel();
        painel.setLayout(new GridLayout(4, 4, 10, 10));

        //linha 1
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        btnDividir = new Button("/");

        painel.add(b7);
        painel.add(b8);
        painel.add(b9);
        painel.add(btnDividir);

        //linha 2
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        btnMultiplicar = new Button("x");

        painel.add(b4);
        painel.add(b5);
        painel.add(b6);
        painel.add(btnMultiplicar);

        //linha 3
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        btnSubtrair = new Button("-");

        painel.add(b1);
        painel.add(b2);
        painel.add(b3);
        painel.add(btnSubtrair);

        //linha 4
        b0 = new Button("0");
        btnPonto = new Button(".");
        btnIgual = new Button("=");
        btnSomar = new Button("+");

        painel.add(b0);
        painel.add(btnPonto);
        painel.add(btnIgual);
        painel.add(btnSomar);

        //adiciona o painel no centro
        add(painel, BorderLayout.CENTER);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        btnSomar.addActionListener(this);
        btnSubtrair.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);
        btnIgual.addActionListener(this);
        btnPonto.addActionListener(this);

        //fechar a janela
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button b = (Button)e.getSource();
        String valor = b.getLabel(); //guarda o texto do botão clicado

        if ("0123456789.".contains(valor)) {
            txtNumero.setText(txtNumero.getText() + valor);
        } else if ("/x-+".contains(valor)) {
            num1 = Double.parseDouble(txtNumero.getText());
            operador = valor;
            txtNumero.setText(" ");
        } else if ("=".equals(valor)) {
            num2 = Double.parseDouble(txtNumero.getText());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "x":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0){
                        resultado = num1 / num2;
                    } else {
                        txtNumero.setText("Erro!");
                        return;
                    }
                    break;

            }
            txtNumero.setText(String.valueOf(resultado));
        }

        if ("C".contains(valor)) {
            txtNumero.setText(" ");
        }
    }

    public static void main(String[] args) {
        new Calculadora().setVisible(true);
    }
}





