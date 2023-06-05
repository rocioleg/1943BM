import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class UI {
    private Juego1943BM juego;

    Graphics2D g2;
    Font arial_40, arial_80B;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;
    public boolean gameFinished = false;

    public int commandNum = 0;

    private Font fuente1;

    private Keyboard keyboard;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(Juego1943BM juego, Keyboard keyboard){
        //arial_40 = new Font("Arial", Font.PLAIN,40);
        //arial_80B = new Font("Arial",Font.BOLD,80);

        this.juego = juego;
        this.keyboard = keyboard;

        try {
            // Ruta de la fuente descargada
            String fontPath = "recursos/fonts/fuente1.ttf";
            
            // Carga la fuente desde el archivo
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            
            // Establece el tamaño y estilo de la fuente
            fuente1 = font.deriveFont(20f); 
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        

    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(fuente1);
        g2.setColor(Color.white);

        // juego pausado
        if(juego.gameState == juego.titleState){
            drawTitleScreen();
        }
        if(juego.gameState == juego.playState){
            // lo normal
        }
        if(juego.gameState == juego.pauseState){
            DrawPause();
        }


    }

    // JUEGO PAUSADO

    public void DrawPause(){
        g2.setFont(fuente1.deriveFont(90F));
        String text = "¡¡PAUSADO!!";
        //int x = getXforCenteredText(text);
        //int y = juego.getHeight()/2;
        double x = juego.p38.getX();
        double y = juego.p38.getY();

        g2.drawString(text,(int)x,(int)y);

    }
    
    public int getXforCenteredText(String text){
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = juego.getWidth() / 2 - length / 2;
        return x;   
    }
    
    
    // Menu del juego
    public void drawTitleScreen(){
        //Titulo
        g2.setFont(fuente1.deriveFont(120F));

        String text = "1943 Batalla de Midway";
        int x = getXforCenteredText(text);
        int y = juego.getHeight()/4;

        g2.setColor(Color.black);
        g2.drawString(text, x+5, y+5);
        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //Menu
        g2.setFont(fuente1.deriveFont(90F));
        text = "Nueva Partida";
        x = getXforCenteredText(text);
        y = juego.getHeight()/2;
        g2.drawString(text, x, y);

        if(commandNum == 0){
            g2.drawString("<",x-20,y);
        }

        text = "Cargar Juego";
        x = getXforCenteredText(text);
        y = juego.getHeight()/2+50;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString("<",x-20,y);
        }

        text = "Salir";
        x = getXforCenteredText(text);
        y = juego.getHeight()/2+100;
        g2.drawString(text, x, y);
        if(commandNum == 2){
            g2.drawString("<",x-20,y);
        }

    }

    public void update(){
        
        if (keyboard.isKeyPressed(KeyEvent.VK_UP)){
            commandNum--;
            if(commandNum < 0){
                commandNum = 2;
            }
        }
 
        if (keyboard.isKeyPressed(KeyEvent.VK_DOWN)){
            commandNum++;
            if(commandNum > 2){
                commandNum = 0;
            }   
        }

        if (keyboard.isKeyPressed(KeyEvent.VK_ENTER)){
        
            switch(commandNum){
                case 0:
                juego.gameState = juego.playState;
                break;
                case 1:
                // se agrega desp
                case 2:
                System.exit(0);

            }
        
        }
    
    }
}
