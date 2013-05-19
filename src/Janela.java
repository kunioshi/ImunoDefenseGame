import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Panel gamePanel = new Panel();
    private Panel infoPanel = new Panel();
    private Label lbl_totalTorres = new Label();
    
    private int totalTorres = 0; 
    
    public Janela(Dimension screen) {
        setLayout( new BorderLayout() );
        
        setSize(screen.width, screen.height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation( (screen.width - getWidth())/2, (screen.height - getHeight())/2 );
        
        gamePanel.addMouseListener( MouseHandler.mouseHandler );
        gamePanel.addMouseMotionListener( MouseHandler.mouseHandler );
        
        infoPanel.add( lbl_totalTorres ); 
        
        add(gamePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);
        
    }
    
    public Panel getGamePanel() {
        return gamePanel;
    }
    
    
    public void incTotalTorres() {
        totalTorres++;
        lbl_totalTorres.setText("Torres: " + totalTorres);
    }
    /*
    public void setPoints(String msg) {
        pointLabel.setText(msg);
    }//*/
    
}
