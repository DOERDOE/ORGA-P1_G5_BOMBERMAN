/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jnpout32.pPort;
/**
 *
 * @author david
 */
public class TableroCaracteres extends javax.swing.JFrame  {

    /**
     * Creates new form TableroCaracteres
     */
    short pin2 = 4;
    short pin3 = 3;
    short cero = 0;
    short uno = 1;
    pPort puerto = new pPort();        
    Runnable actualizarMatrizLed;
    Runnable actualizarLetras;
    Runnable actualizarGraficos;
    ImageIcon player = new ImageIcon("player.png");
        ImageIcon bloq = new ImageIcon("Bloque.png");
        ImageIcon suelo = new ImageIcon("suelo.jpg");

        ImageIcon bom = new ImageIcon("bom1.jpg");
        ImageIcon bom_big = new ImageIcon("bom2.png");
      
        ImageIcon fire_ex = new ImageIcon("fire2.jpg");
        ImageIcon fire_ran = new ImageIcon("fire1.jpg");
        ImageIcon mal = new ImageIcon("malito.png");
        ImageIcon mal2 = new ImageIcon("malito2.png");
        
        ImageIcon win = new ImageIcon("win.png");
        
        ImageIcon bon = new ImageIcon("z_bon.png");
        Matriz m;
    public TableroCaracteres(Matriz m,Controlador c) {
        this.m=m;
        initComponents();
        this.txtMatriz.addKeyListener(c);
        actualizar(m); 
        //actualizarDatos(m);
            actualizarLetras = new Runnable() {
            public void run() {
                while(true){                    
                    try {
                        txtMatriz.setText("");
                        for(int y=0;y<12;y++){
                            for(int x=0;x<12;x++){
                                if(m.m[y][x]!=null){
                                    txtMatriz.setText(txtMatriz.getText()+m.m[x][y].toString());
                                }else{
                                    txtMatriz.setText(txtMatriz.getText()+"O");
                                }
                            }
                            txtMatriz.setText(txtMatriz.getText()+"\n");
                        }
                        Thread.sleep(250);
                    } catch (Exception ex) {
                        Logger.getLogger(TableroCaracteres.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
                }
        };
            TableroCaracteres that = this;
        actualizarMatrizLed = new Runnable() {
            public void run() {
                while(true){
                    try {
                        that.iterarEnX(m,1);
                       // Thread.sleep(5);
                        that.iterarEnX(m,2);
                       // Thread.sleep(5);
                        that.iterarEnX(m,3);
                       // Thread.sleep(5);
                        that.iterarEnX(m,4);
                       // Thread.sleep(5);
                        that.iterarEnX(m,5);
                       // Thread.sleep(5);
                        that.iterarEnX(m,6);
                        //Thread.sleep(5);
                        that.iterarEnX(m,7);
                        //Thread.sleep(5);
                        that.iterarEnX(m,8);
                        //Thread.sleep(5);
                        that.iterarEnX(m,9);
                        //Thread.sleep(5);
                        that.iterarEnX(m,10);
                        //Thread.sleep(5);
                        that.iterarEnX(m,11);
                        //Thread.sleep(5);
                        that.iterarEnX(m,0);
                        //Thread.sleep(5);
                    } catch (Exception ex) {
                        Logger.getLogger(TableroCaracteres.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        actualizarGraficos = new Runnable() {
            public void run() {
                while(true){
                    try {
                        boolean tipo_mal = false;
                        Jp_game.removeAll();
                        //Jp_game = panel2;
//        jt_game.setDefaultRenderer(Object.class, new ImagenTable());
//        DefaultTableModel carpetas = new DefaultTableModel();

for(int y=0;y<12;y++){
    for(int x=0;x<12;x++){
        if(m.m[x][y]!=null){
            
            if (m.m[x][y] == "H"){
                JLabel lab_bloq = new JLabel();
                lab_bloq.setIcon(new ImageIcon(bloq.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_bloq);
                
            }
            else if (m.m[x][y] == "O"){
                JLabel lab_suelo = new JLabel();
                //lab_suelo1 = lab_suelo;
                lab_suelo.setIcon(new ImageIcon(suelo.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_suelo);
            }
            else if (m.m[x][y] == "J"){
                JLabel lab_pla = new JLabel();
                lab_pla.setIcon(new ImageIcon(player.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_pla);
            }
            else if (m.m[x][y] == "B"){
                JLabel lab_bom = new JLabel();
                lab_bom.setIcon(new ImageIcon(bom.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_bom);
            }
            else if (m.m[x][y] == "b"){
                JLabel lab_bom = new JLabel();
                lab_bom.setIcon(new ImageIcon(bom_big.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_bom);
            }
            else if (m.m[x][y] == "F"){
                JLabel lab_pla = new JLabel();
                lab_pla.setIcon(new ImageIcon(fire_ex.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_pla);
            }
            else if (m.m[x][y] == "f"){
                JLabel lab_pla = new JLabel();
                lab_pla.setIcon(new ImageIcon(fire_ran.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_pla);
            }
            else if (m.m[x][y] == "M"){
                JLabel lab_malito = new JLabel();
                if (tipo_mal == false) {
                    lab_malito.setIcon(new ImageIcon(mal.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                    tipo_mal = true;
                }
                else
                {
                    lab_malito.setIcon(new ImageIcon(mal2.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                    tipo_mal = false;
                }
                
                Jp_game.add(lab_malito);
            }
            
            else if (m.m[x][y] == "L"){
                JLabel lab_win = new JLabel();
                lab_win.setIcon(new ImageIcon(win.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_win);
            }
            else if (m.m[x][y] == "Z"){
                JLabel lab_bon = new JLabel();
                lab_bon.setIcon(new ImageIcon(bon.getImage().getScaledInstance(5, 5, Image.SCALE_FAST ) ));
                Jp_game.add(lab_bon);
            }
            
            
        }else{
            
        }
    }
}
//JOptionPane.showMessageDialog(null,"fin1");
scp.setViewportView(Jp_game);
Jp_game.repaint();
Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TableroCaracteres.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        new Thread(actualizarLetras).start();
        new Thread(actualizarMatrizLed).start();
        //new Thread(actualizarGraficos).start();
        this.setVisible(true);
    }
    public void iterarEnX(Matriz m,int y){
        stearDataPin2ClockPin3(((m.m[y][0].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][1].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][2].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][3].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][4].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][5].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][6].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][7].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][8].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][9].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][10].equals("O")) ? (short)0 : (short)1));
        stearDataPin2ClockPin3(((m.m[y][11].equals("O")) ? (short)0 : (short)1));
    }
    public void stearDataPin2ClockPin3(short val){
        try {
            puerto.setPin(pin2, val);
//            Thread.sleep(50);
            puerto.setPin(pin3, uno);
            //Thread.sleep((long)1/100000000);        
            puerto.setPin(pin3, cero);
            //Thread.sleep((long)0.0001);        
        } catch (Exception ex) {
            Logger.getLogger(TableroCaracteres.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarDatos(Matriz m){
       this.lblTitulo.setText("Nivel "+m.nivel);
       this.lblNombre.setText(m.j.getNombre());
       this.lblBombasEspeciales.setText(m.j.getBombasEspeciales()+"");
       this.lblPuntuacion.setText(m.j.getPunteo()+"");
       this.lblVidas.setText(m.j.getVidas()+"");        
    }
    public void actualizarLetras(Matriz m){
    }
    public void actualizarMatrizLed(Matriz m){
    }
    public void actualizar(Matriz m){
        actualizarLetras(m);
        actualizarMatrizLed(m);
        actualizarGraficos(m);
        
    }
    
     public void actualizarGraficos(Matriz m) {
        
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMatriz = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblVidas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblBombasEspeciales = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        scp = new javax.swing.JScrollPane();
        Jp_game = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMatriz.setEditable(false);
        txtMatriz.setColumns(20);
        txtMatriz.setRows(5);
        jScrollPane1.setViewportView(txtMatriz);

        lblTitulo.setText("Nivel 1");

        jLabel1.setText("Nombre");

        lblNombre.setText("Pep");

        jLabel3.setText("Vidas");

        lblVidas.setText("jLabel4");

        jLabel5.setText("Bombas especiales");

        lblBombasEspeciales.setText("jLabel6");

        jLabel8.setText("Puntuación");

        lblPuntuacion.setText("jLabel9");

        Jp_game.setLayout(new java.awt.GridLayout(12, 12));
        scp.setViewportView(Jp_game);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(53, 53, 53)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPuntuacion)
                                    .addComponent(lblBombasEspeciales)
                                    .addComponent(lblVidas)
                                    .addComponent(lblNombre))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblVidas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblBombasEspeciales))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPuntuacion)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jp_game;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBombasEspeciales;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVidas;
    private javax.swing.JScrollPane scp;
    private javax.swing.JTextArea txtMatriz;
    // End of variables declaration//GEN-END:variables
}
