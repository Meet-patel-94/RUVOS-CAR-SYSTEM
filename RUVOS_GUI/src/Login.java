



import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Platform.runLater;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nick
 */
public class Login extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         launch(args);
    }
    
    boolean isPlaying=false,running=false;
    Scene scene2, scene3;
    Slider slider;
    Driver d;
    Car c;
    Timer timer= new Timer();
    Rectangle r1,r2;
    final Text actiontarget = new Text();
    final Text noPass = new Text();
    final Text simUpdate = new Text();
    final Text simSpeed = new Text();
    final Text simGas = new Text();
    final Text songplay= new Text();
    TextField name, userAge, ans1,ans2,ans3,ans4;
    String answer="";
    Stage stage;
   
    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        primaryStage.setTitle("RUVOS");
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(15);
        grid2.setVgap(15);
        grid2.setPadding(new Insets(50, 50, 50, 50));
        
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(50, 50, 50, 50));
        
        
        
       
        Text scenetitle = new Text("RUVOS Driver Login");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        grid.add(scenetitle, 0, 0, 2, 1);
        
        
        Label userName = new Label("Driver:");
        grid.add(userName, 0, 1);
        
        name = new TextField();
        grid.add(name, 1, 1);
        
        Label age = new Label("Age:");
        grid.add(age,0,2);
        
        userAge = new TextField();
        grid.add(userAge,1,2);
        
        grid.add(actiontarget, 1, 6);
        
        Button btn = new Button("Ready?");
        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        btn.setOnAction(e -> btnClick());
       
       
        Scene scene = new Scene(grid, 700, 375);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }
    
    public void btnClick(){
        actiontarget.setFill(Color.FIREBRICK);
       
        if(userAge.getText().length()==0||name.getText().length()==0){
           actiontarget.setText("Missing data...");
           
        }
        
        else{
            try{
            d = new Driver(name.getText(),Integer.parseInt(userAge.getText()));
            c = new Car(d);
            
            Text scenetitle = new Text("RUVOS Test");
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            HBox sceneTitle=new HBox(10,scenetitle);
            sceneTitle.setAlignment(Pos.CENTER);
            sceneTitle.setPadding(new Insets(10));
            
        
            Label q1= new Label("Do you have a valid license?");
            ans1 = new TextField();
            HBox q1pane= new HBox(10,q1,ans1);
            q1pane.setAlignment(Pos.CENTER);
            q1pane.setPadding(new Insets(10));
            
            Label q2 = new Label("Did you drink or use any drug recreationally?");
            ans2 = new TextField();
            HBox q2pane= new HBox(10,q2,ans2);
            q2pane.setAlignment(Pos.CENTER);
            q2pane.setPadding(new Insets(10));
            
             Label q3 = new Label("If quigs are equal to shigs, and shigs are equal to ligs, are all quigs ligs?");
            //grid2.add(q3,0,3);
             ans3 = new TextField();
            //grid.add(ans3,3,3);
           HBox q3pane= new HBox(10,q3,ans3);
           q3pane.setAlignment(Pos.CENTER);
            q3pane.setPadding(new Insets(10));
            
           
            Label q4 = new Label("How do you spell 'racecar' backwards?");
            //grid2.add(q4,0,4);
            ans4 = new TextField();
            //grid.add(ans4,1,4);
            
            HBox q4pane= new HBox(10,q4,ans4);
            q4pane.setAlignment(Pos.CENTER);
            q4pane.setPadding(new Insets(10));
            
            
            Button submit= new Button("Submit");
            
            submit.setOnAction(e -> confirm());
            HBox subBut= new HBox(10,submit);
            subBut.setAlignment(Pos.BOTTOM_CENTER);
            
            HBox alert= new HBox(10,noPass);
            alert.setAlignment(Pos.BOTTOM_CENTER);
            VBox pane = new VBox(10,sceneTitle,q1pane,q2pane,q3pane,q4pane,subBut,alert);
            
           scene2= new Scene(pane,700,375);
           stage.setScene(scene2);
           stage.show();
            }
            catch(NumberFormatException ex){
                actiontarget.setText("Please input a number for the age");
                
            }
           
        }
        
        
    }
    
    public void confirm(){
        answer=ans1.getText()+ans2.getText()+ans3.getText()+ans4.getText();
        System.out.println(answer);
        noPass.setFill(Color.FIREBRICK);
       c.grabAnswer(answer);
       c.start();
       
       if(!c.isOperational()){
          noPass.setText("You failed the drug test... the car is shutting down in 5.");
          PauseTransition delay = new PauseTransition(Duration.seconds(5));
         
          delay.setOnFinished( event -> System.exit(0) );
          
          delay.play();
          
       }
       
       else
       {
           
            r1 = new Rectangle();
            r1.setFill(Color.DARKGRAY);
            r1.setX(50);
            r1.setY(50);
            r1.setWidth(200);
            r1.setHeight(10);
            r1.setArcWidth(10);
            r1.setArcHeight(10);
            
            r2 = new Rectangle();
            r2.setFill(Color.DARKGRAY);
            r2.setX(50);
            r2.setY(50);
            r2.setWidth(200);
            r2.setHeight(10);
            r2.setArcWidth(10);
            r2.setArcHeight(10);  
           
           HBox rec1=new HBox(r1,r2);
           rec1.setAlignment(Pos.BOTTOM_CENTER);
           
           //HBox rec2=new HBox(r2);
          // rec2.setAlignment(Pos.BOTTOM_RIGHT);
           
           
           
           
           ToggleButton swtch = new ToggleButton("Radio On/Off");
           HBox swtchbox = new HBox(swtch);
           swtchbox.setAlignment(Pos.CENTER_LEFT);
           swtch.setOnMouseClicked(e -> playSong());
           
           
           HBox playingnow=new HBox(songplay);
           playingnow.setAlignment(Pos.CENTER_LEFT);
           Text scene3title=new Text("Driver Monitor");
           scene3title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
           HBox title = new HBox(10,scene3title);
           title.setAlignment(Pos.CENTER);
           
           HBox updateMsg = new HBox(10,simUpdate);
           updateMsg.setAlignment(Pos.CENTER);
           
           simGas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
           simGas.setText("--%");
           simSpeed.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
           simSpeed.setText("--km/h");
           
           
           HBox updateSpeed = new HBox(30,simSpeed);
           updateSpeed.setAlignment(Pos.CENTER);
           HBox updateGas= new HBox(30,simGas);
           updateGas.setAlignment(Pos.CENTER_RIGHT);
           Label speedOdo= new Label("Odometer");
           HBox Odo=new HBox(speedOdo);
           Odo.setAlignment(Pos.CENTER);
           Label gasLabel= new Label("Fuel Meter");
           HBox gas=new HBox(gasLabel);
           gas.setAlignment(Pos.CENTER_RIGHT);
           VBox pane = new VBox(10, title, updateMsg,Odo,updateSpeed, swtchbox,playingnow,gas,updateGas,rec1);
           pane.setAlignment(Pos.CENTER);
           pane.setPadding(new Insets(10));
          
          
           scene3=new Scene(pane,700,375);
           scene3.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                
                
                
                simUpdate.setFill(Color.FIREBRICK);
                simUpdate.setVisible(true);
                switch (event.getCode()) {
                    case W:    simUpdate.setText(c.accelerate()); 
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                                
                    break;
                        
                        
                    case S:  simUpdate.setText(c.reverse()) ;
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                                
                    
                    
                    break;
                        
                        
                    
                    case A:  simUpdate.setText(c.left());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                                r1.setFill(Color.DEEPSKYBLUE);
                    
                    break;
                       
                       
                    case D: simUpdate.setText(c.right());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                                r2.setFill(Color.DEEPSKYBLUE);
                    
                    break;
                        
                        
                    case Z: simUpdate.setText(c.braking());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                    
                    break;
                    
                        
                    case ENTER: simUpdate.setText(c.park());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                    
                    break;
                    case T: 
                            if(c.isParked()){
                            
                           
                            simUpdate.setText("System shutting down...");
                            simSpeed.setText("--.-km/H");
                            
                            
                            }
                        
                       break; 
                    case ESCAPE:
                        stage.close();
                        System.exit(0);
                        break;
                }
                
               
                    }
        });

        scene3.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!c.isParked()&&!running){
                    running=true;
                timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            javafx.application.Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    
                    c.braking();
                    simUpdate.setText("-- -- -- --");
                    simSpeed.setText(c.speed());
                    if(c.isParked()){
                        timer.cancel();
                    }
                }
            });
        }
    }, 2, 10000);
            }
                
                
                switch (event.getCode()) {
                    case W:     simUpdate.setText(c.coast());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                               
                            
                    break;
                    case S:   simUpdate.setText(c.coast());
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                                
                    
                    break;
                    case A:      r1.setFill(Color.DARKGRAY);
                    
                    break;
                    case D:     r2.setFill(Color.DARKGRAY);
                    
                    break;
                    case ENTER:  simUpdate.setText(c.park()); 
                                simSpeed.setText(c.speed());
                                simGas.setText(c.gasMeter());
                               
                    
                    break;
                        
                    case T:
                        if(c.isParked()){
                            timer.cancel();
                            simUpdate.setText("System shutting down...");
                            simSpeed.setText("--.-km/h");
                            PauseTransition delay = new PauseTransition(Duration.seconds(5));
                            delay.setOnFinished( evet -> System.exit(0) );
                            delay.play();
                            
                            }
                        
                        
                        
                    break;
                    
                        
                }
                 
    
    
                
            }
        });
           stage.setScene(scene3);
           stage.show();
       }
       
       
      
        
    }
    
   
public void playSong(){
    songplay.setVisible(true);
    if(isPlaying==false){
        c.startRadio();
        songplay.setText(c.getSong());
        isPlaying=true;
    }
    else{
        c.stopRadio();
        songplay.setText(c.getSong());
        isPlaying=false;
    }
    
    
}


    
}
