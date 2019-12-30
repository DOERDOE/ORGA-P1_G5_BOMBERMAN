/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orga.p2_g5_bomberman.objetos;

/**
 *
 * @author david
 */
public class TableroCaracteres extends javax.swing.JFrame  {

    /**
     * Creates new form TableroCaracteres
     */
    public TableroCaracteres(Matriz m,Controlador c) {
        initComponents();
        this.txtMatriz.addKeyListener(c);
        actualizar(m);
        this.setVisible(true);
    }
    public void actualizar(Matriz m){
        this.lblTitulo.setText("Nivel "+m.nivel);
        this.lblNombre.setText(m.j.getNombre());
        this.lblBombasEspeciales.setText(m.j.getBombasEspeciales()+"");
        this.lblPuntuacion.setText(m.j.getPunteo()+"");
        this.lblVidas.setText(m.j.getVidas()+"");
        this.txtMatriz.setText("");
        for(int y=0;y<12;y++){
            for(int x=0;x<12;x++){
                if(m.m[x][y]!=null){
                    this.txtMatriz.setText(this.txtMatriz.getText()+m.m[x][y].toString());
                }else{
                    this.txtMatriz.setText(this.txtMatriz.getText()+"O");                
                }
            }
            this.txtMatriz.setText(this.txtMatriz.getText()+"\n");
        }
        
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMatriz.setEditable(false);
        txtMatriz.setColumns(20);
        txtMatriz.setRows(5);
        jScrollPane1.setViewportView(txtMatriz);

        lblTitulo.setText("Nivel");

        jLabel1.setText("Nombre");

        lblNombre.setText("Pep");

        jLabel3.setText("Vidas");

        lblVidas.setText("jLabel4");

        jLabel5.setText("Bombas especiales");

        lblBombasEspeciales.setText("jLabel6");

        jLabel7.setText("1");

        jLabel8.setText("Puntuación");

        lblPuntuacion.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
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
                            .addComponent(lblNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(jLabel7))
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
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBombasEspeciales;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVidas;
    private javax.swing.JTextArea txtMatriz;
    // End of variables declaration//GEN-END:variables
}
